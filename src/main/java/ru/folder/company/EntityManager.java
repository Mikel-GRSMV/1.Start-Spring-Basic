package ru.folder.company;

import ru.folder.company.employer.Employer;
import ru.folder.company.employer.Worker;

import java.lang.reflect.Array;

//менеджер сущностей<изначально работает с любым типом который ему подастся>
public class EntityManager<T extends Employer> {
    private T[] entities; //список сущностей
    int size; //количество сущностей

    @SuppressWarnings("uncheked")
    public EntityManager(int maxSize, Class<T> clazz) {
        this.entities = (T[]) Array.newInstance(clazz, maxSize);
    }

    //добавить ноаую сущность в массив entities
    public void addEntity(T entity) { //тип сущности не известен
        System.out.println(entity.getName() + " is added");//блогадаря <T extends Employer> я могу получить имя(тк один из подоваемых типов
        //это наследник Employer)
        entities[size] = entity; //по индексу записываю в массив
        size++;
    }

    public int getSize() {
        return size;
    }

    public T[] getEntities() { //вернуть массив всех сущностей, которые сохранил в entities
        return entities;
    }
}
