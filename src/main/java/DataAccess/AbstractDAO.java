package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    public List<T> findAll( ) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        List<T> result = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            result = createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return result;
    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" (");
        Field[] fields = type.getDeclaredFields();
        boolean atLeastOne = false;
        for(Field f: fields) {
            sb.append(f.getName());
            sb.append(",");
            atLeastOne = true;
        }
        if (atLeastOne) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(") VALUES (");
        atLeastOne = false;
        for(Field f: fields) {
            sb.append("?,");
            atLeastOne = true;
        }
        if (atLeastOne) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(" )");
        return sb.toString();
    }

    public void insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery();
        int rowsAffected = 0;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int iterator = 1;
            Field fields[] = type.getDeclaredFields();
            for(Field field: fields) {
                field.setAccessible(true);
                statement.setObject(iterator, field.get(t));
                iterator++;
            }
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        System.out.println("Number of rows affected: " + rowsAffected);
    }

    private String createUpdateQuery(String idField){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        Field fields[] = type.getDeclaredFields();
        boolean atLeastOne = false;
        for(Field field : fields) {
            sb.append(field.getName());
            sb.append(" = ");
            sb.append("?, ");
            atLeastOne = true;
        }
        if (atLeastOne) {
            sb.deleteCharAt(sb.length() - 2);
        }
        sb.append(" WHERE ");
        sb.append(idField);
        sb.append(" = ?");
        return sb.toString();
    }

    public void update(T t, String idField) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery(idField);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int iterator = 1;
            Field fields[] = type.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                statement.setObject(iterator, field.get(t));
                iterator++;
            }
            Field idFieldObj = type.getDeclaredFields()[0];
            idFieldObj.setAccessible(true);
            statement.setObject(iterator, idFieldObj.get(t));
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private String createDeleteQuery(String idField) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(idField);
        sb.append(" = ?");
        return sb.toString();
    }

    public void delete (T t, String idField) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(idField);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            Field idFieldObj = type.getDeclaredFields()[0];
            idFieldObj.setAccessible(true);
            statement.setObject(1, idFieldObj.get(t));
            statement.executeUpdate();;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
