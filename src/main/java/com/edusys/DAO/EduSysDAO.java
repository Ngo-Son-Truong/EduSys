
package com.edusys.DAO;

import java.util.List;


public abstract class EduSysDAO<EntityType, KeyType> {

    public abstract void insert(EntityType entity);// abstract phần khai báo, không có phần thân

    public abstract void update(EntityType entity);

    public abstract void delete(KeyType id);

    public abstract List<EntityType> selectAll();

    public abstract EntityType selectById(KeyType id);

    public abstract List<EntityType> selectBySql(String sql, Object... args);
}
