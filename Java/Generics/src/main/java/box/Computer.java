/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

/**
 *
 * @author Paolo
 */
public class Computer {
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
    public String toString() {
        return "Computer{marca: " + marca + ", ram: " + ram + "}";
    }

}
