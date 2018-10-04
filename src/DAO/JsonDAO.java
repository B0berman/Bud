package DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDAO<T> implements DAO<T, String> {

    protected Class<T>  beanType;

    public JsonDAO(Class<T> type) {
        beanType = type;
    }

    @Override
    public String write(T bean) {
        final Gson gson = new GsonBuilder().create();
        return gson.toJson(bean, bean.getClass());
    }

    @Override
    public T read(String json) {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, beanType);
    }
}
