package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    public boolean persists(E entity) throws IllegalAccessException, SQLException {
        Field id = this.getId(entity.getClass());
        id.setAccessible(true);
        Object value = id.get(entity);

        if (value == null || (int) value <=0) {
            return this.doInsert(entity, id);
        }
        //Update
        return false;
    }

    private boolean doInsert(E entity, Field primary) throws IllegalAccessException, SQLException {
        String query = "INSERT INTO " + this.getTableName(entity.getClass());
        String columns = " (";
        String values = " (";

        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Id.class)) {
                columns += this.getColumnName(field);
                Object value = field.get(entity);
                if (value instanceof Date) {
                    values += "'" + new SimpleDateFormat("yyyy-MM-dd").format(value) + "'";
                } else if (value instanceof Integer) {
                    values += value;
                } else {
                    values += "'" + value + "'";
                }
                if (i < fields.length - 1) {
                    values += ",";
                    columns += ",";
                }
            }

        }

        query += columns + ") VALUES " + values + " )";
        return connection.prepareStatement(query).execute();
    }

    private boolean doUpdate(E entity, Field primary) {
        return false;
    }

    public Iterable<E> find(Class<E> table) {
        return null;
    }

    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    public E findFirst(Class<E> table) {
        return null;
    }

    public E findFirst(Class<E> table, String where) {
        return null;
    }

    private Field getId(Class entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity doesn't have ID!"));
    }

    private String getTableName(Class entity) {
        String tableName = "";
        tableName = ((Entity) entity.getAnnotation(Entity.class)).name();

        if (tableName.equals("")) {
            tableName = entity.getSimpleName();
        }
        return tableName;
    }

    private String getColumnName(Field field) {
        String columnName = "";
        columnName = field.getAnnotation(Column.class).name();

        if (columnName.isEmpty()) {
            columnName = field.getName();

        }
        return columnName;
    }
}
