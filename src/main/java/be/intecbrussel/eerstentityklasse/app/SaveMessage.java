package be.intecbrussel.eerstentityklasse.app;

import be.intecbrussel.eerstentityklasse.messages.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMessage {

    public static void main(String[] args) {



        Message message = new Message();
        message.setId(1);
        message.setContent("Mijn eerste entity Klass!");

        EntityManagerFactory emf = null;
        EntityManager entityManager = null;

        try{
            emf = Persistence.createEntityManagerFactory("course");
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(message);
            transaction.commit();
            System.out.println("message saved");

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            if (entityManager != null){
                entityManager.close();
            }
            if (emf!= null){
                emf.close();
            }
        }


    }
}




