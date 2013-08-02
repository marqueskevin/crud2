/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;



import br.com.modelo.negocio.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author isequiel_borges
 */
public class MarcaTableModel extends AbstractTableModel{
    

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    
    private List<Marca> linhas;
    
    private String[] colunas = {"Id","Nome"};
   
    public MarcaTableModel(){
        linhas = new ArrayList<Marca>();
    }
    
    public MarcaTableModel(List<Marca> marcas){
        linhas = new ArrayList<Marca>();
    }
    /*
     * Retorna a quantidade de linhas da tabela
     */
    public int getRowCount() {
        return linhas.size();       
   
    }

    /*
     * Retorna a quantidade de colunas
     */
    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    public Class getColumnClass(int columnIndex){
        if(columnIndex == COL_ID){
            return Integer.class;
        }
        return String.class;
    }
   /*
    * Retorna os dados do objeto da linha 
    */
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Marca m = linhas.get(rowIndex);
        
        if (columnIndex == COL_ID){
            return m.getId();
        }else if(columnIndex == COL_NOME){
             return m.getNome();
    }
        return " ";
    }
    
    /*
     * Altera os dados de uma linha
     */
    public void setValuet(Object aValue, int rowIndex, int columnIndex){
        Marca m = linhas.get(rowIndex);
        if(columnIndex == COL_ID){
            m.setId((Integer)aValue);
        }else if ( columnIndex == COL_NOME){
            m.setNome(aValue.toString());
        }
    }
    // Indica se a célula é editável
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public Marca getMarca(int indiceLinha){
        return linhas.get(indiceLinha);
    }
            
   public void addMarca(Marca marca){
      // Adiciobna o registro
       linhas.add(marca);
       
       // Pega a quantidader de registros (Os registyros que começam com zero)
       int ultimoIndice = getRowCount() - 1;
       
       //Notifica a mudança 
       fireTableRowsInserted(ultimoIndice, ultimoIndice);
   }   
   // atualiza uma linha
   public void updateMarca(int indiceLinha, Marca marca){
       linhas.set(indiceLinha, marca);
       fireTableRowsUpdated(indiceLinha, indiceLinha);
   }
   // remove uma linha
   public void removeMarca(int indiceLinha){
       linhas.remove(indiceLinha);
       fireTableRowsDeleted(indiceLinha, indiceLinha);
   }
   
   public void limpar(){
       linhas.clear();
   }
            
}
