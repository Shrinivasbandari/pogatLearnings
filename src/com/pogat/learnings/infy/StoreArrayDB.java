//package com.infy;
//
////Import
//
//public class StoreArrayDB{
//  public JSONArray getArrayData(){
//JSONArray list = new JSONArray();
//try{
//list.add("First Array");
//list.add("Second Array");
//list.add("Third Array");
//   }catch(Exception e){
//e.printStackTrace();
//}
//   return list;
//}
//
//public static void main(String args[]){
//
//StoreArrayDB storeArrayDB=new StoreArrayDB();
//JSONArray list=storeArrayDB.getArrayData();
//Connection c = null;
//Statement stmt = null;
//try {
//   Class.forName("org.postgresql.Driver");
//   c = DriverManager
//      .getConnection("jdbc:postgresql://localhost:5432/testdb",
//      "manisha", "123");
//   c.setAutoCommit(false);
//   System.out.println("Opened database successfully");
//
//   String sql = "INSERT INTO JSOnArray VALUES (?)";
//PreparedStatement pstmt = c.prepareStatement(sql);
//
//pstmt.setString(1, list.toString);
//
//}
//
//}	 }
