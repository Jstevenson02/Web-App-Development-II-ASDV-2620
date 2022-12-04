/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bl;

/**
 *
 * @author A. V. Markou
 */
public class Class1 implements Interface1
{
    private int x;
    private String y;

    public Class1(int x, String y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public String getY()
    {
        return y;
    }

    public void setY(String y)
    {
        this.y = y;
    }

    @Override
    public int f1()
    {
        return Integer.valueOf( (int) ( Math.random() * 101) );
    }

    
    
}
