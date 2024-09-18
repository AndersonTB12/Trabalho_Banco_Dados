import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectarBD {

    // Credenciais de conexão
    String jdbcUrl = "jdbc:postgresql://database-1.cuutbuoccaqw.us-east-1.rds.amazonaws.com:5432/academia";
    String username = "professor";
    String password = "professor";
    Connection connection;

    // Construtor para inicializar a conexão
    public ConectarBD(){
        try {
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexao estabelecida com sucesso!");
        }
        catch (Exception e) {
            // Mostra possíveis falhas na conexão:
            e.printStackTrace();
        }
    }

    // Método para inserir uma nova empresa
    public void inserirEmpresa(String nomeEmpresa, String cnpj) throws Exception {
        String queryInsercao = "INSERT INTO public.empresa(nomeempresa, cnpj) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(queryInsercao)) {
            pstmt.setString(1, nomeEmpresa);
            pstmt.setString(2, cnpj);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Linha inserida com sucesso!");
            }
        }
    }

    // Método para consultar todas as empresas
    public void consultarEmpresas() throws Exception {
        String queryConsulta = "SELECT * FROM public.empresa";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(queryConsulta)) {
            System.out.println("Linhas presentes na tabela empresa:\n");
            while (resultSet.next()) {
                System.out.println("idEmpresa: " + resultSet.getString(1));
                System.out.println("nomeEmpresa: " + resultSet.getString(2));
                System.out.println("cnpj: " + resultSet.getString(3));
            }
        }
    }

    public static void main(String[] args) {
        // Dados para inserir. Altere caso deseje
        String cnpj = "00357842000103";
        String nomeEmpresa = "Smart Fit";

        // Cria uma nova conexão
        ConectarBD conexao = new ConectarBD();

        try {
            // Insere a empresa e consulta todas as empresas
            conexao.inserirEmpresa(nomeEmpresa, cnpj);
            conexao.consultarEmpresas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}