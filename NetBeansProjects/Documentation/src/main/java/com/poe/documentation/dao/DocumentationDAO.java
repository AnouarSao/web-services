/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.documentation.dao;

import com.poe.documentation.entity.Category;
import com.poe.documentation.entity.Documentation;
import com.poe.documentation.jpa.EntityManagerSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Anouar-Sao
 */
public class DocumentationDAO {

    // CREATE Doumenatation
    public static void createDoc(Documentation docToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(docToCreate);
        tx.commit();
    }

    // FIND Doumenatation By ID
    public static Documentation findDocById(long docId) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Documentation docToFind = entityManager.find(Documentation.class, docId);

        return docToFind;
    }

    // FIND All Doumenatations
    public static List<Documentation> findAllDocs() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select d from Documentation d");

        return findAllQuery.getResultList();
    }

    // FIND Doumenatation By Category
    public static List<Documentation> findByCategory(Category category) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query queryToFindDocumentationByCategory = entityManager.createQuery("select d from Documentation d where d.category = :category");
        queryToFindDocumentationByCategory.setParameter("category", category);
        return queryToFindDocumentationByCategory.getResultList();
    }

    // UPDATE Doumenatation
    public static void updateDoc(Long docId, Documentation newDocData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Documentation docToUpdate = entityManager.find(Documentation.class, docId);

        docToUpdate.setName(newDocData.getName());
        docToUpdate.setDescription(newDocData.getDescription());
        docToUpdate.setUrl(newDocData.getUrl());
        docToUpdate.setCategory(newDocData.getCategory());

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(docToUpdate);
        tx.commit();
    }

    // DELETE Doumenatation
    public static void deleteDoc(long docId) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Query deleteQuery = entityManager.createQuery("delete from Documentation d where d.id = :id");

        deleteQuery.setParameter("id", docId);
        deleteQuery.executeUpdate();
        entityManager.clear();

        tx.commit();
    }
}
