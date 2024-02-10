package com.benz.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.serviet.encapsulatedclass.mcdBenz;
import com.servlet.jdbc.jdbc;

public class Implementation {
Connection connect;
PreparedStatement prep;
ResultSet resultset;

Statement state;

public Implementation() {
	connect=jdbc.getinstance();
}
public  int Insertmethod(mcdBenz entity) { 
	int result=0;
	String query="insert into benz1 values(?,?,?,?)";
	try {
		prep=connect.prepareStatement(query);
		prep.setInt(1,entity.getModelid());
		prep.setString(2,entity.getModelname());
		prep.setInt(3,entity.getFultype());
		prep.setInt(4, entity.getPrice());
		result=prep.executeUpdate();
	}catch (SQLException e)  {
		e.printStackTrace();
		
	}
	return result;
	}
//read search
public mcdBenz Search(int en) {
	mcdBenz entity= null;
	System.out.println("Implementation class Triggered");
	String ec= String.valueOf(en);
	try {
		String query="select * from benz1 where modelid=?";
		prep=connect.prepareStatement(query);
		prep.setString(1, ec);
		resultset=prep.executeQuery();
		while(resultset.next()) {
			entity=new mcdBenz();
			entity.setModelid(resultset.getInt(1));
			entity.setModelname(resultset.getString(2));
			entity.setFultype(resultset.getInt(3));
			entity.setPrice(resultset.getInt(4));
			
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return entity;
}
//read->Fetch
public List<mcdBenz>Fetch(){
	List<mcdBenz>listproduct = new ArrayList<mcdBenz>();
	String query = "select * from benz1";
	try {
	state=  connect.createStatement();
	resultset=state.executeQuery(query);
	mcdBenz entity=null;
	while(resultset.next()) {
		entity=new mcdBenz();
		entity.setModelid(resultset.getInt(1));
		entity.setModelname(resultset.getString(2));
		entity.setFultype(resultset.getInt(3));
		entity.setPrice(resultset.getInt(4));
		listproduct.add(entity);
	}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return listproduct;
	 
}
}
