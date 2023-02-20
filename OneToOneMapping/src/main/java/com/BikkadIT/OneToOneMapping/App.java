package com.BikkadIT.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Question que = new Question();
		que.setQuestion_id(12);
		que.setQuestion("what is java.?");

		Answer ans = new Answer();
		ans.setAnswer_id(22);
		ans.setAnswer("java is the programing langwadge......");
		que.setAns(ans);

		Question que1 = new Question();
		que1.setQuestion_id(13);
		que1.setQuestion("what is colection.?");

		Answer ans1 = new Answer();
		ans1.setAnswer_id(23);
		ans1.setAnswer("if we want to group of object in a single entity then we should go for collection..... ");
		que.setAns(ans1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(que);
		session.save(que1);
		session.save(ans);
		session.save(ans1);

	//	Question answer = (Question) session.get(Question.class, 12);
	//	System.out.println(answer.getAns());

		tx.commit();
		session.close();
		factory.close();
	}
}
