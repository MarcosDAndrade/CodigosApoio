package Application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    static void main(String[] args) {
      /*  Pessoa p1 = new Pessoa(null, "Carlos da Silva", "Carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Maria Santos", "Maria@gmail.com");
        Pessoa p3 = new Pessoa(null, "Jorge silva da Silva", "Jorge@gmail.com");*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

     /*
        //Inicia o banco de dados e insere os dados nela.
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit(); */

        //Buscar pessoa
        Pessoa p = em.find(Pessoa.class, 2);

        //Sempre usar o transaction para executar o que queremos
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto!");
        em.close();
        emf.close();

    }
}
