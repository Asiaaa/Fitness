/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Joanna
 */
public class Grafik_fitness {
    private int id_instruktor;
    private int id_zajecia;
    private int id_sala;
    private int max_ilosc_miejsc;
    
    public void setIdZajecia(int id_zajecia)
    {
        this.id_zajecia=id_zajecia;
    }
    
    public int getIdZajecia()
    {
        return id_zajecia;
    }
    
    public void setIdSala(int id_sala)
    {
        this.id_sala=id_sala;
    }
    
    public int getIdSala()
    {
        return id_sala;
    }
    
    public void setMaxIloscMiejsc(int max_ilosc_miejsc)
    {
        this.max_ilosc_miejsc=max_ilosc_miejsc;
    }
    
    public int getMaxIloscMiejsc()
    {
        return max_ilosc_miejsc;
    }
}
