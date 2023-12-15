package com.corenetworks.persistencia;

import com.corenetworks.modelo.Empleado;
import com.corenetworks.modelo.Socio;

import java.sql.SQLException;
import java.sql.Statement;

public class AccesoSocios extends Conexion{

    public boolean alta(Socio s) throws SQLException, ClassNotFoundException {
        //1. Declarar variables
        Statement sentencia;
        int resultado=0;
        String sql = "insert into socios (carnet, dni) values('" + s.getCarnet() + "','" +
                s.getDni() + "');";
        //2. Abrir la conexion
        abriConexion();
        //3. Crear el statement
        sentencia = miConexion.createStatement();
        //4. Actualizar
        resultado = sentencia.executeUpdate(sql);
        //5. Devolver el resultado
        return resultado>0;

    }

    public boolean modificar(Empleado e) throws SQLException, ClassNotFoundException {
        //1.Declarar variables
        Statement sentencia;
        int resultado = 0;
        String sql = "update employees set first_name = '"+e.getNombre() +"' where employee_id=" + e.getIdEmpleado();
        //2. Abrir la conexion
        abriConexion();
        //3. Crear el Statement
        sentencia = miConexion.createStatement();
        //4. Modificar
        resultado = sentencia.executeUpdate(sql);
        //5. Devolver el resultado
        return resultado > 0;
    }
}
