/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.documentation.dao;

import com.poe.documentation.entity.Category;
import com.poe.documentation.jpa.EntityManagerSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Anouar-Sao
 */
public class CategoryDAO {

    // CREATE Category
    public static void createCat(Category catToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(catToCreate);
        entityManager.flush();
        entityManager.clear();
        tx.commit();
    }
    
    // FIND Category By ID
    public static Category findCatById(long catId) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Category catToFind = entityManager.find(Category.class, catId);

        return catToFind;
    }

    // FIND All Categories
    public static List<Category> findAllCats() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Category c");

        return findAllQuery.getResultList();
    }

    // UPDATE Category
    public static void updateCat(Long catId, Category newCatData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Category catToUpdate = entityManager.find(Category.class, catId);

        catToUpdate.setName(newCatData.getName());

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(catToUpdate);
        tx.commit();
    }

    // DELETE Category
    public static void deleteCat(long catId) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Query deleteQuery = entityManager.createQuery("delete from Category c where c.id = :id");

        deleteQuery.setParameter("id", catId);
        deleteQuery.executeUpdate();
        entityManager.clear();

        tx.commit();
    }
}
