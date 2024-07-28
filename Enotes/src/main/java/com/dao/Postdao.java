package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.Post;
import com.user.UserDetails;

public class Postdao {
	private Connection conn;

	public Postdao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addNotes(String title, String content, int id) {
		boolean f = false;
		try {
			String qu = "INSERT INTO post(title, contant, uid) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(qu);

			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace(); // Print exception details
		}
		return f;
	}

	public List<Post> getdta(int id) {
		List<Post> list = new ArrayList<Post>();
		Post po = null;
		try {
			String qu = "select * from post where uid=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				po = new Post();
				po.setId(rs.getInt(1));
				po.setTitle(rs.getString(2));
				po.setContant(rs.getString(3));
				po.setpDate(rs.getTimestamp(4));
				list.add(po);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Post getDataById(int note_id) {
		Post p = null;
		try {
			String qu = "select * from post where id=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setInt(1, note_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContant(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public boolean postUpadate(int nid, String ti, String co) {
		boolean f = false;
		try {
			String qu = "update post set title=?,contant=? where id=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, nid);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public boolean deleteNotes(int uId) {
		boolean f = false;
		try {
			String qu = "delete from post where id=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setInt(1, uId);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
