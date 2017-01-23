import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Query {

	public ArrayList<DBObject> runQuery(String selecter, String filter)
			throws UnknownHostException {

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB database = mongo.getDB("test");
		DBCollection coll = database.getCollection("finalcollection");
		BasicDBObject query = new BasicDBObject();
		if (selecter.equals("UserID") || selecter.equals("JobID")
				|| selecter.equals("ManagedHowMany")
				|| selecter.equals("Salary")
				|| selecter.equals("WorkHistoryCount")
				|| selecter.equals("ZipCode")
				|| selecter.equals("TotalYearsExperience")) {
			int value = Integer.parseInt(filter);
			query.append(selecter, value);
		} else {
			query.append(selecter, filter);
		}

		// BasicDBList or = new BasicDBList();
		// or.add(new BasicDBObject("UserID",userid));
		// or.add(new BasicDBObject("TotalYearsExperience",12));

		// { $or: [ { quantity: { $lt: 20 } }, { price: 10 } ] }
		ArrayList<DBObject> res = new ArrayList<DBObject>();
		DBCursor results = coll.find(query);
		for (DBObject t : results) {
			res.add(t);
		}
		return res;
	}

	public static void main(String[] arg) throws UnknownHostException {
		Query q = new Query();
		ArrayList<DBObject> a = q.runQuery("Country", "US");
		for (DBObject d : a) {
			System.out.println(d);
		}
	}

	public ArrayList<DBObject> multiQuery(String[] selecter, String[] filter)
			throws UnknownHostException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB database = mongo.getDB("test");
		DBCollection coll = database.getCollection("finalcollection");
		BasicDBObject query = new BasicDBObject();
		for (int i = 0; i < selecter.length; i++) {
			if (selecter[i].equals("UserID") || selecter[i].equals("JobID")
					|| selecter[i].equals("ManagedHowMany")
					|| selecter[i].equals("Salary")
					|| selecter[i].equals("WorkHistoryCount")
					|| selecter[i].equals("ZipCode")
					|| selecter[i].equals("TotalYearsExperience")) {
				int value = Integer.parseInt(filter[i]);
				query.append(selecter[i], value);
			} else {
				query.append(selecter[i], filter[i]);
			}

		}
		ArrayList<DBObject> res = new ArrayList<DBObject>();
		DBCursor results = coll.find(query);
		for (DBObject t : results) {
			res.add(t);
		}
		return res;
	}

	public ArrayList<DBObject> advQuery(String[] normalselect, String[] filter,
			String[] rangeselect, String[] lfilter, String[] rfilter, boolean or)
			throws UnknownHostException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB database = mongo.getDB("test");
		DBCollection coll = database.getCollection("finalcollection");
		BasicDBObject query = new BasicDBObject();
		if (or) {
			BasicDBList list=new BasicDBList();
			if (rangeselect != null) {
				for (int i = 0; i < rangeselect.length; i++) {
					
					int lbound = Integer.parseInt(lfilter[i]);
					int ubound = Integer.parseInt(rfilter[i]);
					//{ field: { $lte: value} }
					
					list.add(new BasicDBObject( rangeselect[i], new BasicDBObject("$gte",lbound).append("$lte", ubound)));
				//	query.append(rangeselect[i], new BasicDBObject("$lte",ubound));
				}

			}
			if (normalselect != null) {
				for (int i = 0; i < normalselect.length; i++) {
					if (normalselect[i].equals("UserID") || normalselect[i].equals("JobID")
							|| normalselect[i].equals("ManagedHowMany")
							|| normalselect[i].equals("Salary")
							|| normalselect[i].equals("WorkHistoryCount")
							|| normalselect[i].equals("ZipCode")
							|| normalselect[i].equals("TotalYearsExperience")) {
						int value = Integer.parseInt(filter[i]);
						list.add(new BasicDBObject(normalselect[i], value));
					} else {
						list.add(new BasicDBObject(normalselect[i], filter[i]));
					}

				}

			}
			query.append("$or", list);
		} else {
			if (rangeselect != null) {
				for (int i = 0; i < rangeselect.length; i++) {
					
					int lbound = Integer.parseInt(lfilter[i]);
					int ubound = Integer.parseInt(rfilter[i]);
					//{ field: { $lte: value} }
					query.append(rangeselect[i], new BasicDBObject("$gte",lbound).append("$lte", ubound));
				//	query.append(rangeselect[i], new BasicDBObject("$lte",ubound));
				}

			}
			if (normalselect != null) {
				for (int i = 0; i < normalselect.length; i++) {
					if (normalselect[i].equals("UserID") || normalselect[i].equals("JobID")
							|| normalselect[i].equals("ManagedHowMany")
							|| normalselect[i].equals("Salary")
							|| normalselect[i].equals("WorkHistoryCount")
							|| normalselect[i].equals("ZipCode")
							|| normalselect[i].equals("TotalYearsExperience")) {
						int value = Integer.parseInt(filter[i]);
						query.append(normalselect[i], value);
					} else {
						query.append(normalselect[i], filter[i]);
					}

				}

			}
		}
		ArrayList<DBObject> res = new ArrayList<DBObject>();
		System.out.println(query);
		DBCursor results = coll.find(query);
		for (DBObject t : results) {
			res.add(t);
		}
		return res;
	}
}
