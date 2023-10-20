package com.java.inf;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class FatchData {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from Question");
		List<Question> list = query.list();
		
		for(Question question : list){
			System.out.println("Question Name "+question.getQname());
			List<Answer> list1 = question.getAnswers();
			for(Answer ans : list1){
				System.out.println(ans.getAnswername()+ ":" + ans.getPostedBy());
			}
		}
	}
}
