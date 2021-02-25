/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacce2;

/**
 *
 * @author alfonso
 */
public class Computer implements Loggable{
    private final String marca;
    private final int ram;

    public Computer(String marca, int ram) {
        this.marca = marca;
        this.ram = ram;
    }

    public String getMarca() {
        return marca;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public void log() {
        System.out.println("-------------- sono un Computer ---------------");
        System.out.println(String.format("le mie caratteristiche sono: marca %s, ram %s", marca,ram));
    }
    
    
}
