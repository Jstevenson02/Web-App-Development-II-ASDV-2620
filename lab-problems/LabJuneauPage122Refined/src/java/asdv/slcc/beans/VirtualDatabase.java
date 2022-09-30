/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdv.slcc.beans;
import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public interface VirtualDatabase {
        void addAuthor(Author a);
        void removeAuthor(Author a);
        ArrayList<Author> getList();
}
