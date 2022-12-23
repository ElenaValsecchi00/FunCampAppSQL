package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

	/**
	 * @author vava5
	 *
	 */
	public class Main {
		
		/**
		 * Method that generate insert query
		 * @param table
		 * @param columns
		 * @param values
		 * @throws Exception
		 */
		public static String ins(String table, String[] columns, String[] values) throws Exception
		{
			try 
			{
				Connection conn = getConnection();
				String col = Arrays.stream(columns).collect(Collectors.joining(","));
				String val = Arrays.stream(values).collect(Collectors.joining(","));
				String insQ = "INSERT INTO" + table + "(" + col +")" + "VALUES" + "(" + val + ")";;
				Statement stmt = conn.createStatement();
				boolean res = stmt.execute(insQ);
				System.out.println(res);
				return "Operazione effettuata";
			}
			catch(Exception e) {System.out.println(e);return e.toString();}
		}
		
		/**
		 * Seleziona ogni elemento di una tabella o vista
		 * @param table
		 * @return
		 * @throws Exception
		 */
		public static String select(String table) throws Exception
		{
			try
			{
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				String selQ = "select * from "+table+";";
				ResultSet rs = stmt.executeQuery(selQ);
				ResultSetMetaData rsmd = rs.getMetaData();
				String result = "";
				int columnC = rsmd.getColumnCount();
				while(rs.next())
				{
					for(int i=1; i<columnC+1;i++)
					{
						result+=rsmd.getColumnName(i)+": "+rs.getString(i)+", ";
					}
					result = result.substring(0, result.length()-2);
					result+="\n";
				}
				return result;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		}
		public static void callins() throws Exception
		{
			ins("`addetto sicurezza`", Stream.of("CodiceD", "Cognome", "Nome","AnniServC").toArray(String[]::new), Stream.of("8","'Alberto'","'Manoli'", "4").toArray(String[]::new));
			ins("`addetto sicurezza`", Stream.of("CodiceD", "Cognome", "Nome","AnniServC").toArray(String[]::new), Stream.of("9","'Maria Chiara'","'Tassoli'", "6").toArray(String[]::new));
			ins("`addetto sicurezza`", Stream.of("CodiceD", "Cognome", "Nome","AnniServC").toArray(String[]::new), Stream.of("10","'Carmine'","'Monicelli'", "11").toArray(String[]::new));
			ins("`addetto sicurezza`", Stream.of("CodiceD", "Cognome", "Nome","AnniServC").toArray(String[]::new), Stream.of("12","'Carla'","'Ciarrua'", "1").toArray(String[]::new));
			ins("`addetto reception`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("5","'Giacomo'","'Botticelli'", "1").toArray(String[]::new));
			ins("`addetto reception`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("2","'Carola'","'Molletta'", "4").toArray(String[]::new));
			ins("`addetto reception`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("7","'Marco'","'Cassarà'", "2").toArray(String[]::new));
			ins("`addetto reception`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("4","'Giovanna'","'Neri'", "10").toArray(String[]::new));
			ins("`direttore`", Stream.of("CF", "Nome", "Cognome","Stipendio","AnniServ").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","'Chiara'","'Colaci'", "3000","13").toArray(String[]::new));
			ins("`inserviente`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("1","'Giacomo'","'Bonomini'", "3").toArray(String[]::new));
			ins("`inserviente`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("3","'Maria Luisa'","'Molletta'", "0").toArray(String[]::new));
			ins("`inserviente`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("6","'Matteo'","'Spadari'", "4").toArray(String[]::new));
			ins("`inserviente`", Stream.of("Codiced", "Nome", "Cognome","AnniServC").toArray(String[]::new), Stream.of("11","'Ginevra'","'Lundini'", "11").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("1","'Carlo'","'Carta'", "11").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("2","'Giacomo'","'Boria'", "15").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("3","'Assunta'","'Tucceri'", "20").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("4","'Viola'","'Aria'", "9").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("5","'Marco'","'Aria'", "11").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("6","'Giuseppe'","'Aria'", "43").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("7","'Ornella'","'Carpi'", "18").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("8","'Gaia'","'Carpi'", "21").toArray(String[]::new));
			ins("`cliente`", Stream.of("numEntrata", "Nome", "Cognome","età").toArray(String[]::new), Stream.of("9","'Armando'","'Galimberti'", "32").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("1","4","'2021-07-26'").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("2","5","'2021-07-26'").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("3","5","'2021-07-26'").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("4","4","'2021-07-27'").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("5","4","'2021-07-27'").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("6","2","'2021-07-27'").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("7","2","'2021-07-27'").toArray(String[]::new));
			ins("`transazione`", Stream.of("codiceT","importo","data").toArray(String[]::new), Stream.of("8","5","'2021-07-28'").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("1","1").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("1","2").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("4","3").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("3","4").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("3","5").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("5","6").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("1","7").toArray(String[]::new));
			ins("`acquisto`", Stream.of("numEntrata", "codiceT").toArray(String[]::new), Stream.of("2","8").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Gara a ostacoli delfini'","'2021-07-26'","'10:00:00'", "'10:30:00'","'conAnimali'").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Spettacolo di magia'","'2021-07-26'","'18:00:00'", "'19:30:00'","'senzaAnimali'").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Fossa dei leoni'","'2021-07-27'","'11:00:00'", "'12:00:00'","'conAnimali'").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Ballo caraibico'","'2021-07-27'","'10:00:00'", "'10:30:00'","'senzaAnimali'").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Serata Jazz'","'2021-07-28'","'21:00:00'", "'23:30:00'","'senzaAnimali'").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Sfilata canina'","'2021-07-29'","'16:00:00'", "'16:30:00'","'conAnimali'").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Spettacolo di magia'","'2021-07-30'","'18:00:00'", "'19:30:00'","'senzaAnimali'").toArray(String[]::new));
			ins("`evento speciale`", Stream.of("nome", "data", "OraF","OraI","Selettore").toArray(String[]::new), Stream.of("'Fossa delle tigri'","'2021-07-31'","'11:00:00'", "'12:00:00'","'conAnimali'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("1","'2021-07-26'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("2","'2021-07-26'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("3","'2021-07-26'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("4","'2021-07-27'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("5","'2021-07-27'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("6","'2021-07-28'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("7","'2021-07-28'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("8","'2021-07-29'").toArray(String[]::new));
			ins("`pacchetto offerta`", Stream.of("idP", "dataVal").toArray(String[]::new), Stream.of("9","'2021-07-30'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'08:00:00'", "'13:00:00'","1","'2021-07-26'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'13:00:00'", "'18:00:00'","2","'2021-07-26'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'18:00:00'", "'23:00:00'","3","'2021-07-26'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","1","'2021-07-27'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","2","'2021-07-27'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","3","'2021-07-27'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","1","'2021-07-27'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","1","'2021-07-28'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","2","'2021-07-28'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","3","'2021-07-28'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'08:00:00'", "'13:00:00'","1","'2021-07-29'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'13:00:00'", "'18:00:00'","2","'2021-07-29'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'18:00:00'", "'23:00:00'","3","'2021-07-29'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","1","'2021-07-30'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","2","'2021-07-30'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","3","'2021-07-30'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","1","'2021-07-31'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","2","'2021-07-31'").toArray(String[]::new));
			ins("`turno lavoro`", Stream.of("OraI", "OraF", "NumT","DataT").toArray(String[]::new), Stream.of("'10:00:00'", "'10:30:00'","3","'2021-07-31'").toArray(String[]::new));
			ins("`addestratore`", Stream.of("CF","nome","cognome").toArray(String[]::new), Stream.of("'MCHVNN92M18H501Q'","'Michele'","'Vanni'").toArray(String[]::new));
			ins("`addestratore`", Stream.of("CF","nome","cognome").toArray(String[]::new), Stream.of("'LBRBNS95M16L219U'","'Alberto'","'Beninsegna'").toArray(String[]::new));
			ins("`addestratore`", Stream.of("CF","nome","cognome").toArray(String[]::new), Stream.of("'FRNVLR89B70F839U'","'Franca'","'Valeri'").toArray(String[]::new));
			ins("`addestratore`", Stream.of("CF","nome","cognome").toArray(String[]::new), Stream.of("'JNACMP90C56Z114V'","'Jane'","'Champion'").toArray(String[]::new));
			ins("`addestratore`", Stream.of("CF","nome","cognome").toArray(String[]::new), Stream.of("'LGOSRN00R64Z154T'","'Olga'","'Smirnov'").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "LimiteEtà", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("1","12","'Giostra Infernale'","'08:00:00'", "'17:30:00'","20").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("2","'Ruota Panoramica'","'08:00:00'", "'22:00:00'","15").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "LimiteEtà", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("3","7","'Macchine Autoscontro'","'08:00:00'", "'22:00:00'","10").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("4","'Tiro a Segno'","'08:00:00'", "'17:30:00'","3").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("5","'Casa dell orrore'","'08:00:00'", "'17:30:00'","30").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("6","'Giostra'","'08:00:00'", "'17:30:00'","8").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "LimiteEtà", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("7","12","'Montagna Russa'","'08:00:00'", "'17:30:00'","20").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "LimiteEtà", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("8","12","'Montagna Russa Acquatica'","'08:00:00'", "'17:30:00'","15").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "LimiteEtà", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("9","7","'Sedie Rotanti'","'08:00:00'", "'22:00:00'","10").toArray(String[]::new));
			ins("`attrazione`", Stream.of("Codice", "Nome","OraA","OraC","NPostiDisponibili").toArray(String[]::new), Stream.of("10","'Sala giochi da Tavolo'","'08:00:00'", "'22:00:00'","20").toArray(String[]::new));
			ins("`benefit`", Stream.of("nOrdine", "Descrizione").toArray(String[]::new), Stream.of("1","'Pasti gratis nel parco di divertimenti'").toArray(String[]::new));
			ins("`benefit`", Stream.of("nOrdine", "Descrizione").toArray(String[]::new), Stream.of("2","'Due giorni di ferie in più annuali'").toArray(String[]::new));
			ins("`benefit`", Stream.of("nOrdine", "Descrizione").toArray(String[]::new), Stream.of("3","'Avere a disposizione un telefono aziendale'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Momo'","'Leone Bianco'", "'carnivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Maui'","'Ippopotamo'", "'erbivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Blu'","'Tigre della Malesia'", "'carnivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Siria'","'Defino'", "'carnivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Ade'","'Carlino'", "'onnivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Toby'","'Baroncino'", "'onnivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Charlie'","'Delfino'", "'carnivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Miss Piggy'","'Bassotto Nano'", "'onnivora'").toArray(String[]::new));
			ins("`animale`", Stream.of("nome", "specie", "dieta").toArray(String[]::new), Stream.of("'Solone'","'Cane Lupo'", "'onnivora'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("1","1000.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("2","1000.00","2", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("3","1000.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("4","1000.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("5","1200.00","3", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("6","1200.00","2", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("7","1200.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("8","1200.00","2", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("9","1500.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("10","1500.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("11","1500.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("12","1500.00","1", "'dipendente'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("13","10.00","3", "'aOre'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("14","10.00","6", "'aOre'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("15","1000.00","2", "'aOre'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("16","1000.00","3", "'aOre'").toArray(String[]::new));
			ins("`contratto`", Stream.of("ID", "Stipendio", "AnniC","Selettore").toArray(String[]::new), Stream.of("17","1000.00","3", "'aOre'").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("8","2").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("8","4").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("9","1").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("9","6").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("10","3").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("10","7").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("12","5").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("12","9").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("8","8").toArray(String[]::new));
			ins("`assegnazione a`", Stream.of("CodiceDSic", "CodiceAttrazione").toArray(String[]::new), Stream.of("12","10").toArray(String[]::new));
			/**
			 * 	ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","1").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","2").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","3").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","4").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","5").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","6").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","7").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","8").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","9").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","10").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","11").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","12").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","13").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","14").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","15").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","16").toArray(String[]::new));
			ins("`stipulazione`", Stream.of("CFDirettore", "IDContratto").toArray(String[]::new), Stream.of("'CLCCHR80B51H501X'","17").toArray(String[]::new));
			 */	
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("2","1", "'2021-07-26'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("2","2", "'2021-07-27'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("2","3", "'2021-07-28'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("2","1", "'2021-07-29'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("2","2", "'2021-07-30'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("4","2", "'2021-07-26'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("4","3", "'2021-07-27'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("4","1", "'2021-07-28'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("4","2", "'2021-07-29'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("4","3", "'2021-07-31'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("5","3", "'2021-07-26'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("5","1", "'2021-07-27'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("5","2", "'2021-07-28'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("5","3", "'2021-07-30'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("7","1", "'2021-07-31'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("7","3", "'2021-07-29'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("7","1", "'2021-07-30'").toArray(String[]::new));
			ins("`assegnazione tr`", Stream.of("CodiceDRec", "nTurno", "DTurno").toArray(String[]::new), Stream.of("7","2", "'2021-07-31'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("1", "'Ade'","'Carlino'","'Croccantini'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("1", "'Blu'","'Tigre della Malesia'","'Bistecche'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("1", "'Charlie'","'Delfino'","'Pesce'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("3", "'Maui'","'Ippopotamo'","'Frutta'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("3", "'Miss Piggy'","'Bassotto Nano'","'Croccantini'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("6", "'Siria'","'Delfino'","'Pesce'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("6", "'Momo'","'Leone Bianco'","'Bistecche'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("11", "'Solone'","'Cane Lupo'","'Croccantini'").toArray(String[]::new));
			ins("`nutrimento`", Stream.of("CodiceDI", "NomeAnimale", "SpecieAnimale","Cibo").toArray(String[]::new), Stream.of("11", "'Toby'","'Barboncino'","'Croccantini'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'MCHVNN92M18H501Q'", "'Toby'","'Barboncino'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'LBRBNS95M16L219U'", "'Blu'","'Tigre della Malesia'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'FRNVLR89B70F839U'", "'Charlie'","'Delfino'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'JNACMP90C56Z114V'", "'Maui'","'Ippopotamo'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'MCHVNN92M18H501Q'", "'Miss Piggy'","'Bassotto Nano'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'FRNVLR89B70F839U'", "'Siria'","'Delfino'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'LGOSRN00R64Z154T'", "'Momo'","'Leone Bianco'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'MCHVNN92M18H501Q'", "'Solone'","'Cane Lupo'").toArray(String[]::new));
			ins("`addestramento`", Stream.of("CodiceAddestratore", "NomeAnimale", "SpecieAnimale").toArray(String[]::new), Stream.of("'MCHVNN92M18H501Q'", "'Ade'","'Carlino'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("8","1", "'2021-07-26'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("8","2", "'2021-07-27'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("8","3", "'2021-07-28'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("8","1", "'2021-07-29'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("8","2", "'2021-07-30'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("9","2", "'2021-07-26'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("9","3", "'2021-07-27'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("9","1", "'2021-07-28'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("9","2", "'2021-07-29'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("9","3", "'2021-07-31'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("10","3", "'2021-07-26'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("10","1", "'2021-07-27'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("10","2", "'2021-07-28'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("10","3", "'2021-07-30'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("12","1", "'2021-07-31'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("12","3", "'2021-07-29'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("12","1", "'2021-07-30'").toArray(String[]::new));
			ins("`assegnazione ts`", Stream.of("CodiceDSic", "numTurno", "DataTurno").toArray(String[]::new), Stream.of("12","2", "'2021-07-31'").toArray(String[]::new));
			ins("`firma a`", Stream.of("CFAddestratore", "IDContratto").toArray(String[]::new), Stream.of("'MCHVNN92M18H501Q'","13").toArray(String[]::new));
			ins("`firma a`", Stream.of("CFAddestratore", "IDContratto").toArray(String[]::new), Stream.of("'LBRBNS95M16L219U'","14").toArray(String[]::new));
			ins("`firma a`", Stream.of("CFAddestratore", "IDContratto").toArray(String[]::new), Stream.of("'FRNVLR89B70F839U'","15").toArray(String[]::new));
			ins("`firma a`", Stream.of("CFAddestratore", "IDContratto").toArray(String[]::new), Stream.of("'JNACMP90C56Z114V'","16").toArray(String[]::new));
			ins("`firma di`", Stream.of("CodiceDI", "IDContratto").toArray(String[]::new), Stream.of("1","1").toArray(String[]::new));
			ins("`firma di`", Stream.of("CodiceDI", "IDContratto").toArray(String[]::new), Stream.of("3","3").toArray(String[]::new));
			ins("`firma di`", Stream.of("CodiceDI", "IDContratto").toArray(String[]::new), Stream.of("6","4").toArray(String[]::new));
			ins("`firma di`", Stream.of("CodiceDI", "IDContratto").toArray(String[]::new), Stream.of("11","8").toArray(String[]::new));
			ins("`firma dr`", Stream.of("CodiceDRec", "IDContratto").toArray(String[]::new), Stream.of("2","2").toArray(String[]::new));
			ins("`firma dr`", Stream.of("CodiceDRec", "IDContratto").toArray(String[]::new), Stream.of("4","7").toArray(String[]::new));
			ins("`firma dr`", Stream.of("CodiceDRec", "IDContratto").toArray(String[]::new), Stream.of("5","10").toArray(String[]::new));
			ins("`firma dr`", Stream.of("CodiceDRec", "IDContratto").toArray(String[]::new), Stream.of("7","11").toArray(String[]::new));
			ins("`firma ds`", Stream.of("CodiceDSic", "IDContratto").toArray(String[]::new), Stream.of("8","5").toArray(String[]::new));
			ins("`firma ds`", Stream.of("CodiceDSic", "IDContratto").toArray(String[]::new), Stream.of("9","6").toArray(String[]::new));
			ins("`firma ds`", Stream.of("CodiceDSic", "IDContratto").toArray(String[]::new), Stream.of("10","9").toArray(String[]::new));
			ins("`firma ds`", Stream.of("CodiceDSic", "IDContratto").toArray(String[]::new), Stream.of("12","12").toArray(String[]::new));
			ins("`riferimento a`", Stream.of("CodiceT", "CodiceAttrazione").toArray(String[]::new), Stream.of("6","1").toArray(String[]::new));
			ins("`riferimento a`", Stream.of("CodiceT", "CodiceAttrazione").toArray(String[]::new), Stream.of("7","5").toArray(String[]::new));
			ins("`riferimento p`", Stream.of("CodiceT", "idp").toArray(String[]::new), Stream.of("1","1").toArray(String[]::new));
			ins("`riferimento p`", Stream.of("CodiceT", "idp").toArray(String[]::new), Stream.of("4","4").toArray(String[]::new));
			ins("`riferimento p`", Stream.of("CodiceT", "idp").toArray(String[]::new), Stream.of("5","7").toArray(String[]::new));
			ins("`riferimento e`", Stream.of("CodiceT", "NomeEvento","DataEvento").toArray(String[]::new), Stream.of("2","'Ballo Caraibico'","'2021-07-27'").toArray(String[]::new));
			ins("`riferimento e`", Stream.of("CodiceT", "NomeEvento","DataEvento").toArray(String[]::new), Stream.of("3","'Fossa dei leoni'","'2021-07-27'").toArray(String[]::new));
			ins("`riferimento e`", Stream.of("CodiceT", "NomeEvento","DataEvento").toArray(String[]::new), Stream.of("8","'Serata Jazz'","'2021-07-28'").toArray(String[]::new));
			ins("`inclusioneb`", Stream.of("IDContratto", "nOrdine").toArray(String[]::new), Stream.of("12","2").toArray(String[]::new));
			ins("`inclusioneb`", Stream.of("IDContratto", "nOrdine").toArray(String[]::new), Stream.of("1","2").toArray(String[]::new));
			ins("`inclusioneb`", Stream.of("IDContratto", "nOrdine").toArray(String[]::new), Stream.of("5","2").toArray(String[]::new));
			ins("`inclusioneb`", Stream.of("IDContratto", "nOrdine").toArray(String[]::new), Stream.of("14","1").toArray(String[]::new));
			ins("`inclusioneb`", Stream.of("IDContratto", "nOrdine").toArray(String[]::new), Stream.of("9","3").toArray(String[]::new));
			ins("`inclusione`", Stream.of("numPac", "CodiceA").toArray(String[]::new), Stream.of("7","1").toArray(String[]::new));
			ins("`inclusione`", Stream.of("numPac", "CodiceA").toArray(String[]::new), Stream.of("7","4").toArray(String[]::new));
			ins("`inclusione`", Stream.of("numPac", "CodiceA").toArray(String[]::new), Stream.of("7","8").toArray(String[]::new));
			ins("`inclusione`", Stream.of("numPac", "CodiceA").toArray(String[]::new), Stream.of("4","1").toArray(String[]::new));
			ins("`inclusione`", Stream.of("numPac", "CodiceA").toArray(String[]::new), Stream.of("4","2").toArray(String[]::new));
			ins("`inclusione`", Stream.of("numPac", "CodiceA").toArray(String[]::new), Stream.of("1","6").toArray(String[]::new));
			ins("`inclusione`", Stream.of("numPac", "CodiceA").toArray(String[]::new), Stream.of("1","9").toArray(String[]::new));
			
		}
		
		/**
		 * Method that generate a connection
		 * @return
		 * @throws Exception
		 */
		public static Connection getConnection() throws Exception
		{
			try
			{
				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/";
				String database = "FunCampApp";
				String username = "root";
				String password = "MySQL";
				
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(url+database+"?user="+username+"&password="+password+"&useJDBCCompliantTimezoneShift=true&useLegacyDateTimeCode=false&serverTimezone=Europe/Rome");

				System.out.println("Connected");
				
				
				return conn;
			}catch(Exception e) {System.out.println(e);}
			
			return null;
		}
		
		/**
		 * Estrarre i receptionist che non sono stati assegnati ad alcun turno di lavoro il giorno corrente
		 * @param data
		 * @throws Exception
		 */
		public static String query1(String data) throws Exception
		{
			try 
			{
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				Statement viewstmt = conn.createStatement();
				String viewQ = "create or replace view ReceptionistTurno as select * from `addetto reception` r join `assegnazione tr` on CodiceD = CodiceDRec, `turno lavoro` where nTurno=NumT and DTurno=DataT;"; 
				String selQ = "select distinct CodiceD, Nome, Cognome, AnniServC from ReceptionistTurno where CodiceD not in (select CodiceD from ReceptionistTurno where DataT = "+data+");";
				viewstmt.execute(viewQ);
				String result = "";
				if (stmt.execute(selQ))
				{
					ResultSet rs = stmt.getResultSet();
					while (rs.next())
					{
						int ID = rs.getInt("CodiceD");
						String Cognome = rs.getString("Cognome");
						String Nome = rs.getString("Nome");
						int AnniServC = rs.getInt("AnniServC");
						result += "CodiceD: " + ID + ", Cognome: " + Cognome + ", Nome: " + Nome + ", AnniServC: " + AnniServC+"\n";
					}
					return result;
				}
				else return null;
			}
			catch(Exception e) {System.out.println(e);return null;}			
		}
		
		/**
		 * Estrarre i dati dei addetti alla sicurezza che percepiscono uno stipendio superiore ai 1000 euro mensili
		 * @throws Exception
		 */
		public static String query2() throws Exception
		{
			Connection conn = getConnection();
			try 
			{			
				Statement stmt = conn.createStatement();
				String selQ = "select a. * from `addetto sicurezza` a  join `firma ds` on CodiceD = CodiceDSic, contratto where IDContratto = ID and Stipendio>1000;";
				String result="";
				if (stmt.execute(selQ))
				{
					ResultSet rs = stmt.getResultSet();
					while (rs.next())
					{
						int ID = rs.getInt("CodiceD");
						String Cognome = rs.getString("Cognome");
						String Nome = rs.getString("Nome");
						int AnniServC = rs.getInt("AnniServC");
						result+="CodiceD: " + ID + ", Cognome: " + Cognome + ", Nome: " + Nome + ", AnniServC: " + AnniServC+"\n";
					}
				}
				return result;
			}
			catch(Exception e) 
			{System.out.println(e);}
			return null;
		}
		
		/**
		 * Estrarre il numero di pacchetti offerta  acquistati nel giorno corrente e i codici dei clienti che li hanno acquistati
		 * @param data
		 * @throws Exception
		 */
		public static String query3(String data) throws Exception
		{
			try 
			{
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				Statement viewstmt = conn.createStatement();
				String viewQ = "create or replace view AcquistiPacchettiOfferta as select a.numEntrata, t.*, r.idP from acquisto a, transazione t, `riferimento p` r  where a.codiceT=t.codiceT and a.codiceT=r.codiceT;"; 
				String selQ = "select count(*), numEntrata from AcquistiPacchettiOfferta a where a.data="+data+";";
				viewstmt.execute(viewQ);
				String result="";
				if (stmt.execute(selQ))
				{
					ResultSet rs = stmt.getResultSet();
					while (rs.next())
					{
						int count = rs.getInt("count(*)");
						int numEntrata = rs.getInt("numEntrata");
						result+="count(*): " + count + ", numEntrata: " + numEntrata+"\n";
					}
				}
				return result;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		}
		
		/**
		 * Estrarre il numero dei partecipanti agli eventi nel giorno corrente
		 * @param data
		 * @throws Exception
		 */
		public static String query4(String data) throws Exception
		{
			try 
			{
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				Statement viewstmt = conn.createStatement();
				String viewQ = "create or replace view AcquistiEventi as select a.numEntrata, t.codiceT, e.DataEvento, e.NomeEvento from `riferimento e` e, transazione t, acquisto a where a.codiceT=t.codiceT and a.codiceT=e.codiceT;"; 
				String selQ = "select count(*) from AcquistiEventi where DataEvento="+data+";";
				viewstmt.execute(viewQ);
				String result="";
				if (stmt.execute(selQ))
				{
					ResultSet rs = stmt.getResultSet();
					while (rs.next())
					{
						int count = rs.getInt("count(*)");
						result+="count(*): " + count+"\n";
					}
				}
				return result;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		}
		
		/**
		 * Query che permette a un cliente di acquistare un biglietto per un'attrazione
		 * @param nome
		 * @param cognome
		 * @param età
		 * @param importo
		 * @param data
		 * @param codiceattrazione
		 * @throws Exception
		 */
		public static String query5(String nome, String cognome, String età, String data,String codiceattrazione) throws Exception
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try 
			{
				//Inizia a Inserire
				String checkClientQ = "select * from cliente where Nome="+nome+" and Cognome="+cognome+" and età="+età+";";
				Statement stmt = conn.createStatement();
				int numEntrata = 0; int codiceT = 0;
				//Controlla se il cliente abbia o no effettuato un'altra transazione (e quindi sia già nel sistema) 
				if (stmt.execute(checkClientQ))
				{
					ResultSet rs = stmt.getResultSet();
					//Se no il cliente viene inserito nel database e viene effettuata la transazione
					if(!rs.next())
					{
						String insC = "insert into cliente (nome, cognome, età) values("+nome+","+cognome+","+età+");";
						stmt.execute(insC);
						stmt.execute(checkClientQ);
						System.out.println("sss2");
						rs = stmt.getResultSet();
						rs.next();
						numEntrata = rs.getInt("numEntrata");
					}
					else
					{
						numEntrata = rs.getInt("numEntrata");
					}
				}
				String insT = "insert into transazione (importo, data) values(2,"+data+");";
				String selT = "select codiceT from transazione where codiceT in (select max(codiceT) from transazione);";
				stmt.execute(insT);
				if (stmt.execute(selT))
				{
					ResultSet rs = stmt.getResultSet();
					rs.next();
					codiceT = rs.getInt("codiceT");
				}
				String insA = "insert into acquisto (codiceT, numEntrata) values("+codiceT+","+numEntrata+");";
				stmt.execute(insA);
				String insR = "insert into `riferimento a` (codiceT, CodiceAttrazione) values("+codiceT+","+codiceattrazione+");";
				stmt.execute(insR);
				conn.commit();
				return "Operazione effettuata";
			}
			catch(Exception e) {
				System.out.println(e);
				//Si prova il RollBack
		         try{
		        	 try {
			             if(conn!=null)
			                conn.rollback();
			             	System.out.println("roll");
			             	return e.toString();
		             }catch(SQLException se2){
		                se2.printStackTrace();
		             }
		          }catch(Exception e2){
		             e2.printStackTrace();
		          }
			}
			return null;
		}
		
		/**
		 * Registra l'acquisto di un pacchetto offerta
		 * @param nome
		 * @param cognome
		 * @param età
		 * @param importo
		 * @param data
		 * @param codiciattrazione
		 * @param idp
		 * @throws Exception
		 */
		public static String query6(String nome, String cognome, String età, String data, String idp) throws Exception
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try 
			{
				//Inizia a Inserire
				String viewQ="create or replace view acquistipacchettiinc as select a.*, i.CodiceA from acquistipacchettiofferta a , inclusione i where i.numPac=a.idp;";
				String checkClientQ = "select * from cliente where Nome="+nome+" and Cognome="+cognome+" and età="+età+";";
				Statement stmt = conn.createStatement();
				stmt.execute(viewQ);
				ResultSet rs;
				int numEntrata = 0; int codiceT = 0;
				//Controlla se il cliente abbia o no effettuato un'altra transazione (e quindi sia già nel sistema) 
				if (stmt.execute(checkClientQ))
				{
					rs = stmt.getResultSet();
					//Se no il cliente viene inserito nel database e viene effettuata la transazione
					if(!rs.next())
					{
						String insC = "insert into cliente (nome, cognome, età) values("+nome+","+cognome+","+età+");";
						stmt.execute(insC);
						stmt.execute(checkClientQ);
						rs = stmt.getResultSet();
						rs.next();
						numEntrata = rs.getInt("numEntrata");
					}
					else
					{
						numEntrata = rs.getInt("numEntrata");
						String checkPQ="select * from acquistipacchettiinc where numEntrata="+numEntrata+" and idp="+idp+" and data="+data+";";
						stmt.execute(checkPQ); rs=stmt.getResultSet();
						if(rs.next())return "Pacchetto già acquistato in questa data";
					}
				}
				//Registra la transazione e selezionane il numero
				String insT = "insert into transazione (importo, data) values(4,"+data+");";
				String selT = "select codiceT from transazione where codiceT in (select max(codiceT) from transazione);";
				stmt.execute(insT);
				if (stmt.execute(selT))
				{	
					rs = stmt.getResultSet();rs.next();
					codiceT = rs.getInt("codiceT");
				}
				//Registra l'acquisto e il riferimento al pacchetto
				String insA = "insert into acquisto (codiceT, numEntrata) values("+codiceT+","+numEntrata+");";
				stmt.execute(insA);
				String insR = "insert into `riferimento p` (codiceT, idp) values("+codiceT+","+idp+");";
				stmt.execute(insR);
				System.out.println("commit");
				conn.commit();
				return "Operazione riuscita";
			}
			catch(Exception e) {
				System.out.println(e);
				//Si prova il RollBack
		         try{
		        	 try {
			             if(conn!=null)
			                conn.rollback();
			             	System.out.println("roll");
			             	return e.toString();
		             }catch(SQLException se2){
		                se2.printStackTrace();
		             }
		          }catch(Exception e2){
		             e2.printStackTrace();
		          }
			}
			return null;
		}
		
		/**
		 * Estrarre i dati degli animali che vanno nutriti dall’inserviente scelto
		 * @param nome
		 * @param cognome
		 * @throws Exception
		 */
		public static String query7(String nome, String cognome) throws Exception
		{
			try 
			{
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				String selQ = "select a.* from animale a, nutrimento , inserviente i where CodiceD=CodiceDI and a.nome = NomeAnimale and a.specie = SpecieAnimale and i.nome ="+nome+ " and i.cognome ="+cognome+";";
				String result="";
				if (stmt.execute(selQ))
				{
					ResultSet rs = stmt.getResultSet();
					while (rs.next())
					{
						String Specie = rs.getString("specie");
						String Nome = rs.getString("nome");
						String Dieta = rs.getString("dieta");
						result+="nome: " + Nome + ", specie: " + Specie + ", dieta: " + Dieta+"\n";
					}
				}
				return result;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		}
		
		/**
		 * Registra acquisto evento speciale
		 * @param nome
		 * @param cognome
		 * @param età
		 * @param importo
		 * @param data
		 * @param nomeevento
		 * @param dataevento
		 * @throws Exception
		 */
		public static String query8(String nome, String cognome, String età, String data,String nomeevento, String dataevento) throws Exception
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try 
			{
				//Inizia a Inserire
				String checkClientQ = "select * from cliente where Nome="+nome+" and Cognome="+cognome+" and età="+età+";";
				Statement stmt = conn.createStatement();
				int numEntrata = 0; int codiceT = 0;
				ResultSet rs = stmt.getResultSet();
				//Controlla se il cliente abbia o no effettuato un'altra transazione (e quindi sia già nel sistema) 
				if (stmt.execute(checkClientQ))
				{
					rs = stmt.getResultSet();
					//Se no il cliente viene inserito nel database e viene effettuata la transazione
					if(!rs.next())
					{
						String insC = "insert into cliente (nome, cognome, età) values("+nome+","+cognome+","+età+");";
						stmt.execute(insC);
						stmt.execute(checkClientQ);
						rs = stmt.getResultSet();
						rs.next();
						numEntrata = rs.getInt("numEntrata");
					}
					else
					{
						numEntrata = rs.getInt("numEntrata");
						//Controlla che lo stesso cliente non abbia già acuistato un biglietto per lo stesso evento
						String checkE = "select * from acquistieventi where numEntrata="+numEntrata+" and NomeEvento="+nomeevento+" and DataEvento="+dataevento+";";
						stmt.execute(checkE);
						rs = stmt.getResultSet();
						if(rs.next()) {return "Il biglietto è già stato acquistato";}
					}
				}
				String insT = "insert into transazione (importo, data) values(5,"+data+");";
				String selT = "select codiceT from transazione where codiceT in (select max(codiceT) from transazione);";
				stmt.execute(insT);
				if (stmt.execute(selT))
				{
					rs = stmt.getResultSet();
					rs.next();
					codiceT = rs.getInt("codiceT");
				}
				String insA = "insert into acquisto (codiceT, numEntrata) values("+codiceT+","+numEntrata+");";
				stmt.execute(insA);
				String insE = "insert into `riferimento e` (codiceT, NomeEvento, DataEvento) values("+codiceT+","+nomeevento+","+dataevento+");";
				stmt.execute(insE);
				System.out.println("commit");
				conn.commit();
				return "Operazione riuscita";
			}
			catch(Exception e) {
				System.out.println(e);
				//Si prova il RollBack
		         try{
		        	 try {
			             if(conn!=null)
			                conn.rollback();
			             	System.out.println("roll");
			             	return e.toString();
		             }catch(SQLException se2){
		                se2.printStackTrace();
		             }
		          }catch(Exception e2){
		             e2.printStackTrace();
		          }
			}
			return null;
		}
		/**
		 * Estrarre il numero di clienti con età inferiore a quella scelta che sono entrati nel parco
		 * @param età
		 * @throws Exception
		 */
		public static String query9(String età) throws Exception
		{
			try 
			{
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				String selQ = "select count(*) from cliente where età<="+età+";";
				String result="";
				if (stmt.execute(selQ))
				{
					ResultSet rs = stmt.getResultSet();
					while (rs.next())
					{
						int count = rs.getInt("count(*)");
						result+="count(*): " + count+"\n";
					}
				}
				return result;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		}
		
		/**
		 * Estrarre i dati dei lavoratori dipendenti che presentano dei benefit nel contratto
		 * @throws Exception
		 */
		public static String query10() throws Exception
		{
			try 
			{
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				Statement viewstmt1 = conn.createStatement();
				Statement viewstmt2 = conn.createStatement();
				Statement viewstmt3 = conn.createStatement();
				String viewQ1 = "create or replace view Lavoratori as select * from `addetto sicurezza` union all select * from `addetto reception` union all select * from inserviente;"; 
				String viewQ2 = "create or replace view ContrattiConBenefit as select i.* from inclusioneb i, contratto c where c.ID=i.IDContratto;";
				String viewQ3 = "create or replace view Firme as select * from `firma di` union all select * from `firma ds` union all select * from `firma dr`;";
				String selQ = "select distinct l.* from Lavoratori l, ContrattiConBenefit c, Firme f where l.CodiceD=f.CodiceDI and f.IDContratto=c.IDContratto;";
				viewstmt1.execute(viewQ1);
				viewstmt2.execute(viewQ2);
				viewstmt3.execute(viewQ3);
				String result = "";
				if (stmt.execute(selQ))
				{
					ResultSet rs = stmt.getResultSet();
					while (rs.next())
					{
						String Nome = rs.getString("Nome");
						String Cognome = rs.getString("Cognome");
						int CodiceD = rs.getInt("CodiceD");
						int AnniServC = rs.getInt("AnniServC");
						result+="CodiceD: " + CodiceD + ", Cognome: " + Cognome + ", Nome: " + Nome + ", AnniServC: " + AnniServC+"\n";
					}
				}
				return result;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		}
		
		/**
		 * Firma un contratto da dipendente
		 * @param nome
		 * @param cognome
		 * @param tipod
		 * @param stipendio
		 * @param anniC
		 * @throws Exception
		 */
		public static String query11(String nome, String cognome, String tipod, String stipendio, String anniC) throws Exception
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try 
			{
				Statement stmt = conn.createStatement();
				String codiceD = "";
				String checkDQ = "select * from "+tipod+" where nome="+nome+" and cognome="+cognome+";";
				boolean isExsisting = false;
				ResultSet rs;
				if (stmt.execute(checkDQ))
				{
					rs = stmt.getResultSet();
					//Se no il cliente viene inserito nel database e viene effettuata la transazione
					if(!rs.next())
					{
						String insC = "insert into "+tipod+"  (nome, cognome, AnniServC) values("+nome+","+cognome+",0);";
						stmt.execute(insC);
						stmt.execute(checkDQ);
						rs = stmt.getResultSet();
						rs.next();
						codiceD = String.valueOf(rs.getInt("CodiceD"));
					}
					else
					{
						codiceD = String.valueOf(rs.getInt("CodiceD"));
						isExsisting = true;
					}
				}
				@SuppressWarnings("preview")
				String tipoF;
				String column;
				switch(tipod.strip())
				{
				case "`inserviente`": tipoF="`firma di`"; column="CodiceDI";break;
				case "`addetto reception`": tipoF= "`firma dr`"; column="CodiceDRec";break;
				case "`addetto sicurezza`": tipoF= "`firma ds`"; column="CodiceDSic";break;
				default: tipoF= "`firma di`"; column="CodiceDI";break;
				};
				
				//Elimina il precedente contratto qualora dovesse esserci
				if(isExsisting)
				{
					String delFQ = "delete from "+tipoF+" where "+column+"="+codiceD+";";
					stmt.execute(delFQ);
				}
				//Firma il Contratto
				String insCQ = "insert into contratto (Stipendio, AnniC, Selettore) values("+stipendio+","+anniC+",'dipendente');";
				stmt.execute(insCQ);
				String ID;
				String selC = "select ID from contratto where ID in (select max(ID) from contratto)";
				stmt.execute(selC);
				rs = stmt.getResultSet();rs.next();
				ID = String.valueOf(rs.getInt("ID"));
				String firmaQ = "insert into "+tipoF+"(IDContratto, "+column+") values ("+ID+","+codiceD+");";
				stmt.execute(firmaQ);
				//Stipula il contratto
				String CF;
				String cfDQ="select CF from direttore";
				stmt.execute(cfDQ);
				rs = stmt.getResultSet();rs.next();
				CF =rs.getString("CF");
				String insSQ="insert into stipulazione(CFDirettore,IDContratto) values('"+CF+"',"+ID+")";
				stmt.execute(insSQ);
				conn.commit();
				return "Operazione riuscita";
			}
			catch(Exception e) {
				System.out.println(e);
				//Si prova il RollBack
		         try{
		        	 try {
			             if(conn!=null)
			                conn.rollback();
			             	System.out.println("roll");
			             	return e.toString();
		             }catch(SQLException se2){
		                se2.printStackTrace();
		             }
		          }catch(Exception e2){
		             e2.printStackTrace();
		          }
			}
			return null;
		}
		
		/**
		 * Assegna benefit a un contratto da dipendente
		 * @param codiceD
		 * @param benefit
		 * @throws Exception
		 */
		public static String query11(String codiceD, String benefit) throws Exception
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try 
			{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.getResultSet();
				String IDContratto;
				String caVQ= "create or replace view contrattiassegnati as select distinct l.*, c.ID from lavoratori l join contratto c join `firma di` i join `firma ds` s join `firma dr` r on (l.CodiceD=i.CodiceDI and i.IDContratto=c.ID) or (l.CodiceD=r.CodiceDRec and r.IDContratto=c.ID) or (l.CodiceD=s.CodiceDSic and s.IDContratto=c.ID);";
				stmt.execute(caVQ);
				//Seleziona l'id del contratto
				String selCQ= "select ID from contrattiassegnati ca where ca.CodiceD="+codiceD+";";
				stmt.execute(selCQ);
				rs = stmt.getResultSet();rs.next();
				IDContratto= String.valueOf(rs.getInt("ID"));
				String insbQ = "insert into inclusioneb(IDContratto,nOrdine) values("+IDContratto+","+benefit+");";
				stmt.execute(insbQ);
				conn.commit();
				return "Operazione riuscita";
			}
			catch(Exception e) {
				System.out.println(e);
				//Si prova il RollBack
		         try{
		        	 try {
			             if(conn!=null)
			                conn.rollback();
			             	System.out.println("roll");
			             	return e.toString();
		             }catch(SQLException se2){
		                se2.printStackTrace();
		             }
		          }catch(Exception e2){
		             e2.printStackTrace();
		          }
			}
			return null;
			
		}
		
		/**
		 * Stipula un contratto con un addestratore
		 * @param nome
		 * @param cognome
		 * @param CFA
		 * @param stipendio
		 * @param giorni
		 * @throws Exception
		 */
		public static String query12(String nome, String cognome, String CFA, String stipendio, String giorni) throws Exception
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try 
			{
				Statement stmt = conn.createStatement();
				String checkDQ = "select * from addestratore where CF="+CFA+";";
				ResultSet rs;
				if (stmt.execute(checkDQ))
				{
					rs = stmt.getResultSet();
					//Se no il cliente viene inserito nel database e viene effettuata la transazione
					if(!rs.next())
					{
						String insC = "insert into addestratore (nome, cognome,CF) values("+nome+","+cognome+","+CFA+");";
						stmt.execute(insC);
						stmt.execute(checkDQ);
						rs = stmt.getResultSet();
						rs.next();
					}
					else
					{
						String delFQ = "delete from `firma a` where CFAddestratore="+CFA+";";
						stmt.execute(delFQ);
					}
				}
				
				//Firma il Contratto
				String insCQ = "insert into contratto (Stipendio, Selettore, Giorni) values("+stipendio+",'aOre',"+giorni+");";
				stmt.execute(insCQ);
				String ID;
				String selC = "select ID from contratto where ID in (select max(ID) from contratto)";
				stmt.execute(selC);
				rs = stmt.getResultSet();rs.next();
				ID = String.valueOf(rs.getInt("ID"));
				String firmaQ = "insert into `firma a`(IDContratto, CFAddestratore) values ("+ID+","+CFA+");";
				stmt.execute(firmaQ);
				
				//Stipula il contratto
				String CF;
				String cfDQ="select CF from direttore";
				stmt.execute(cfDQ);
				rs = stmt.getResultSet();rs.next();
				CF =rs.getString("CF");
				String insSQ="insert into stipulazione(CFDirettore,IDContratto) values('"+CF+"',"+ID+")";
				stmt.execute(insSQ);
				conn.commit();
				return "Operazione riuscita";
			}
			catch(Exception e) {
				System.out.println(e);
				//Si prova il RollBack
		         try{
		        	 try {
			             if(conn!=null)
			                conn.rollback();
			             	System.out.println("roll");
			             	return e.toString();
		             }catch(SQLException se2){
		                se2.printStackTrace();
		             }
		          }catch(Exception e2){
		             e2.printStackTrace();
		          }
			}
			return null;
		}
		
		public static String query12(String CF, String benefit) throws Exception
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try 
			{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.getResultSet();
				String IDContratto;
				//Seleziona l'id del contratto
				String selCQ= "select c.ID from contratto c, `firma a` f where f.CFAddestratore="+CF+" and f.IDContratto=c.ID;";
				stmt.execute(selCQ);
				rs = stmt.getResultSet();rs.next();
				IDContratto= String.valueOf(rs.getInt("ID"));
				String insbQ = "insert into inclusioneb(IDContratto,nOrdine) values("+IDContratto+","+benefit+");";
				stmt.execute(insbQ);
				conn.commit();
				return "Operazione riuscita";
			}
			catch(Exception e) {
				System.out.println(e);
				//Si prova il RollBack
		         try{
		        	 try {
			             if(conn!=null)
			                conn.rollback();
			             	System.out.println("roll");
			             	return e.toString();
		             }catch(SQLException se2){
		                se2.printStackTrace();
		             }
		          }catch(Exception e2){
		             e2.printStackTrace();
		          }
			}
			return null;
		}
		/**
		 * Main
		 * @param args
		 */
		public static void main(String[] args)  throws Exception{
			//callins();
			System.out.println(select("`cliente`"));
			/**
			 *System.out.println(query1("'2021-07-31'"));
			System.out.println(query2());
			System.out.println(query3("'2021-07-27'"));
			System.out.println(query4("'2021-07-27'"));
			//System.out.println(query5("'V'","'c'","9","'2021-08-01'","7"));
			System.out.println(query6("'Paolo'","'Mieli'","3","'2021-07-26'","3"));
			System.out.println(query7("'Giacomo'", "'Bonomini'"));
			System.out.println(query8("'Ornella'","'Carpi'","18","'2021-07-30'","'Spettacolo di magia'","'2021-07-30'"));
			System.out.println(query9("12"));
			System.out.println(query10());
			System.out.println(query11("'Carolina'","'Morace'","`addetto sicurezza`", "1500", "2"));
			System.out.println(query11("18","3"));
			System.out.println(query12("'Roberta'","'Mago'", "'MGARRT98H68L736E'", "10","3"));
			System.out.println(query12("'MGARRT98H68L736E'","1")); 
			 */
			
		}

	}

