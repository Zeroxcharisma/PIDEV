package edu.db3a3.services;

import edu.db3a3.entities.Produit;
import edu.db3a3.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;





public class BonPlanService {
	private static BonPlanService instance;
	private Statement st;
	private ResultSet rs;
          public static final String ACCOUNT_SID = "ACaca2408ccb8f8ace1456705e087746de";
            public static final String AUTH_TOKEN = "127a70d8a3a0d011e4d48b7ce129d0c3";
     
        
        
	Connection myDB;

	public BonPlanService() {
		try {
		myDB = MyConnection.getInstance().getCnx();

		/* MyDB cs=myDB.getInstance(); */

			st = myDB.createStatement();
		} catch (SQLException ex) {
			Logger.getLogger(BonPlanService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static BonPlanService getInstance() throws ClassNotFoundException {
		if (instance == null)
			instance = new BonPlanService();
		return instance;
	}

	public void ajouterBonPlan(Produit bp, int lengh) {

		try {
			PreparedStatement prep;
			String query = "insert into produit (nom_bp,type_bp,desc_bp,img_bp,prix_bp) values (? , ? , ? , ?, ?)";// varchar 'var'
			prep = myDB.prepareStatement(query);

			prep.setString(1, bp.getNom_bp());
			prep.setString(2, bp.getType_bp());
			prep.setString(3, bp.getDesc_bp());
			prep.setBinaryStream(4,bp.getImg_bp(), lengh);
			prep.setDouble(5, bp.getPrix_bp());
			prep.executeUpdate();
			System.out.println("Ajout OK!");
		} catch (SQLException ex) {
			Logger.getLogger(BonPlanService.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
        
	public void supprimerBonPlan(Produit bp) {
		PreparedStatement prep;
		try {
			prep = myDB.prepareStatement("delete from produit where nom_bp = ?");
			prep.setString(1, bp.getNom_bp());
			prep.executeUpdate();
                      
			System.out.println("delete OK!");
		} catch (SQLException ex) {
			System.out.println("Probleme de suppression!");
		}

	}

	public void modifierBonPlan(Produit bp, int length) {

		try {
			PreparedStatement prep;
			String req;
			req = "UPDATE produit SET nom_bp=?,type_bp=?,desc_bp=?,img_bp=?,prix_bp=? WHERE id_bp = " + bp.getId_bp();

			prep = myDB.prepareStatement(req);

			prep.setString(1, bp.getNom_bp());
			prep.setString(2, bp.getType_bp());
			prep.setString(3, bp.getDesc_bp());
			prep.setBinaryStream(4, bp.getImg_bp(),length);
			prep.setDouble(5, bp.getPrix_bp());

			prep.executeUpdate();
			System.out.println("Modification OK!");
		} catch (SQLException ex) {
			System.out.println("Probl�me de Modification");
		}
	}
	
	public void modifierBonPlansansimage(Produit bp) {

		try {
			PreparedStatement prep;
			String req;
			req = "UPDATE produit SET `nom_bp`=?,`type_bp`=?,`desc_bp`=?,`prix_bp`=? WHERE id_bp = " + bp.getId_bp();

			prep = myDB.prepareStatement(req);

			prep.setString(1, bp.getNom_bp());
			prep.setString(2, bp.getType_bp());
			prep.setString(3, bp.getDesc_bp());
			prep.setDouble(4, bp.getPrix_bp());

			prep.executeUpdate();
			System.out.println("Modification OK!");
		} catch (SQLException ex) {
			System.out.println("Probl�me de Modification");
		}
	}

	public Produit selectBonPlan(int id_bp) throws SQLException {

		Produit bp = new Produit();

		Statement stm = myDB.createStatement();
		ResultSet rest = stm.executeQuery("select * from produit where id_bp =" + id_bp + "");

		while (rest.next()) {
			bp.setId_bp(rest.getInt(1));
			bp.setNom_bp(rest.getString(2));
			bp.setType_bp(rest.getString(3));
			bp.setDesc_bp(rest.getString(4));
			bp.setImg_bp(rest.getBinaryStream(5));
			bp.setPrix_bp(rest.getDouble(6));
		}
		System.out.println(bp.toString());
		return bp;

	}
	

	public void supprimerBonPlan(int id_bp) {

		PreparedStatement prep;
		try {
			prep = myDB.prepareStatement("delete from produit where id_bp = ?");
			prep.setInt(1, id_bp);
			prep.executeUpdate();
			System.out.println("delete OK!");
		} catch (SQLException ex) {
			System.out.println("Probleme de suppression!");
		}

	}
	
	public List<Produit> displayAllListtrie() {
		String req = "select * from produit order by prix_bp asc";
		List<Produit> list = new ArrayList<>();

		try {
			rs = st.executeQuery(req);
			while (rs.next()) {
				Produit p = new Produit();
				p.setId_bp(rs.getInt(1));
				p.setNom_bp(rs.getString("nom_bp"));
				p.setType_bp(rs.getString("type_bp"));
				p.setDesc_bp(rs.getString("desc_bp"));
				p.setPrix_bp(rs.getDouble("prix_bp"));
				p.setImg_bp(rs.getBinaryStream("img_bp"));
				list.add(p);
			}

		} catch (SQLException ex) {
			Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
		}
		return list;
	}

	public List<Produit> displayAllList() {
		String req = "select * from produit";
		List<Produit> list = new ArrayList<>();

		try {
			rs = st.executeQuery(req);
			while (rs.next()) {
				Produit p = new Produit();
				p.setId_bp(rs.getInt(1));
				p.setNom_bp(rs.getString("nom_bp"));
				p.setType_bp(rs.getString("type_bp"));
				p.setDesc_bp(rs.getString("desc_bp"));
				p.setPrix_bp(rs.getDouble("prix_bp"));
				p.setImg_bp(rs.getBinaryStream("img_bp"));

				list.add(p);
			}

		} catch (SQLException ex) {
			Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
		}
		return list;
	}
	
	public List<Produit> displayRecherche(String critere) {
		String req = "select * from produit where LOWER(nom_bp) like '%"+critere+"%' or LOWER(desc_bp) like '%"+critere+"%' or LOWER(type_bp) like '%"+critere+"%'";
		List<Produit> list = new ArrayList<>();

		try {
			rs = st.executeQuery(req);
			while (rs.next()) {
				Produit p = new Produit();
				p.setId_bp(rs.getInt(1));
				p.setNom_bp(rs.getString("nom_bp"));
				p.setType_bp(rs.getString("type_bp"));
				p.setDesc_bp(rs.getString("desc_bp"));
				p.setPrix_bp(rs.getDouble("prix_bp"));
				p.setImg_bp(rs.getBinaryStream("img_bp"));
				list.add(p);
			}

		} catch (SQLException ex) {
			Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
		}
		return list;
	}
	
	public static boolean ControleFloat(String prix) {
		if ((prix).matches("([0-9]*[.])?[0-9]+")){
			return true;
		}
		return false;
	}
	
	public static boolean ControleInt(String prix) {
		if ((prix).matches("[0-9]+")){
			return true;
		}
		return false;
	}
	
	public static boolean ControleNom(String str) {
		str = str.toLowerCase();
                if (str.length() == 0)
                    return false;
		char[] charArray = str.toCharArray();
                
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
	}

}
