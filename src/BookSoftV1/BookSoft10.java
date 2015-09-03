
package BookSoftV1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class BookSoft10 {
   static ArrayList Names=new ArrayList();
   static ArrayList Count=new ArrayList();
   static ArrayList Prestamo=new ArrayList();
   static ArrayList Cedula=new ArrayList();
   static ArrayList LibroPrestado=new ArrayList();
   private String Nombre;
   private String Autor;
   private String Año;
   private String Codigo;
   private int Cantidad;
   private String Area;
   
   public void Ingresar_Libro(String nombre,String autor,String año,String codigo,String area,int cantidad)
   {
       Nombre=nombre;
       Autor=autor;
       Año=año;
       Codigo=codigo;
       Cantidad=cantidad;
       Area=area;
       Names.add(nombre);
       Count.add(cantidad);
       Prestamo.add(0);
   }
   
   public void Actualizar_Libro(String nombre,String autor,String año,String codigo,String area,int cantidad,int i)
   {
       Nombre=nombre;
       Autor=autor;
       Año=año;
       Codigo=codigo;
       Cantidad=cantidad;
       Area=area;
       Names.set(i, nombre);
       Count.set(i, cantidad);
   }
   
   
   public boolean Actualizar_Libro(String nombre)
   {
       int i;
       i=Names.indexOf(Nombre);
           if (i>-1)
              return true;
           else
              return false;
   }
   
   public void Eliminar_Libro(String nombre)
   {
       int i;
       i=Names.indexOf(nombre);
       if (i>-1)
       {
           Names.remove(i);
           Count.remove(i);
           Nombre="";
           Año="";
           Autor="";
           Codigo="";       
           Cantidad=0;
           Area="";
           System.out.println("Libro Eliminado...");
           
       }            
       else
           System.out.println("El Libro no existe, Imposible Eliminar");
   }
   
  public boolean Buscar_Libro(String nombre)
  {
      int i;
      i=Names.indexOf(nombre);
      if (i>-1)
          return true;
      else
         return false;
  }
  
  public void Mostrar_datos()
  {
      System.out.println("Nombre del Libro: "+Nombre);
      System.out.println("Autor: "+Autor);
      System.out.println("Año de Publicacion: "+Año);
      System.out.println("Codigo: "+Codigo);
      System.out.println("Cantidad Disponible: "+Cantidad);
      System.out.println("Area: "+Area);
  }
  
  public void Devolver_Libros(String cedula)
  {
      int i,num,presta;
      String nombre;
      i=Cedula.indexOf(cedula);
      if(i>-1)
      {      
        nombre=(String)LibroPrestado.get(i);
        i=Names.indexOf(nombre);
        num=(int)Count.get(i);
        presta=(int)Prestamo.get(i);      
        num++;
        presta--;
        Count.set(i, num);
        Cantidad=num;
        Prestamo.set(i, presta);
        i=Cedula.indexOf(cedula);
        Cedula.remove(i);              
        LibroPrestado.remove(i);
        System.out.println("El libro Prestado es:"+ nombre);
        System.out.println("");
        System.out.println("El fue libro Devuelto Satisfactoriamente");
      }
      else
          System.out.println("No hay Libros en Prestamo para este numero de Cedula");
      
  }

  public void Prestar_Libros(String nombre,String cedula)
  {
      int i,num,presta;
      i=Names.indexOf(nombre);
      num=(int)Count.get(i);
      presta=(int)Prestamo.get(i);
      if(num==0)
          System.out.println("No hay Copias Disponibles..");
      if(num>0)
      {
          num--;
          presta++;
          Count.set(i, num);
          Cantidad=num;
          Prestamo.set(i, presta);
          Cedula.add(cedula);
          i=Cedula.indexOf(cedula);
          LibroPrestado.add(i,nombre);     
                    
      } 
      
  }
  
  public void Libros_Prestados()
  {
      System.out.println("Listado de Libros en Prestamo");
      System.out.println("");
      System.out.println("Libro         Cedula");
      int x=LibroPrestado.size();
      for(int i=0;i<x;i++)
      {
          System.out.println(LibroPrestado.get(i)+"     "+Cedula.get(i));
      }
      System.out.println("");
      System.out.println("Inventario de Libros");
      System.out.println("");
      System.out.println("Libro    Disponibles    Prestamo");
      x=Names.size();
      for(int i=0;i<x;i++)
      {
          System.out.println(Names.get(i)+"       "+Count.get(i)+"            "+Prestamo.get(i));
      }
      
  }
   
  
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        BookSoft10 Libro[]=new BookSoft10[10];
        int n=0,i;
        String x,nombre,autor,año,codigo,cantidad,area;
        int cantidad1;
        boolean salir=true,areaV=true;
        for (i=0;i<=9;i++)
            Libro[i]=new BookSoft10();
        Names.clear();
        Count.clear();
        do
        {
        System.out.println("Programa Administracion de Libros");
        System.out.println("");
        System.out.println("1. Ingresar Libro");
        System.out.println("2. Actualizar Libro");
        System.out.println("3. Eliminar Libro");
        System.out.println("4. Buscar Libro");
        System.out.println("5. Prestar Libro");
        System.out.println("6. Devolver Libro");
        System.out.println("7. Lista de Prestamos");
        System.out.println("8. Salir");
        System.out.println("");
        System.out.print("Seleccione la Opcion Deseada: ");
        x=teclado.next();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (x)
        {
            case "1":
                System.out.println("Ingrese el Nombre del Libro");
                nombre=teclado.next();              
                System.out.println("Ingrese El Autor del Libro");
                autor=teclado.next();
                System.out.println("Ingrese El año de Publicacion");
                año=teclado.next();;
                System.out.println("Ingrese el Codigo");
                codigo=teclado.next();
                System.out.println("Ingrese la Cantidad de libros");
                cantidad=teclado.next();
                cantidad1=Integer.parseInt(cantidad);
                do
                {
                    System.out.println("Selccione el Area del Libro");
                    System.out.println("");
                    System.out.println("1.Qumica");
                    System.out.println("2.Fisica");
                    System.out.println("3.Tecnologia");
                    System.out.println("4.Calculo");
                    System.out.println("5.Programacion");
                    System.out.println("");
                    System.out.println("El Area del Libro es: ");
                    area=teclado.next();
                    switch (area)
                            {
                        case "1":
                            area="Qumica";
                            areaV=false;
                            break;
                        case "2":
                            area="Fisica";
                            areaV=false;
                            break;
                        case "3":
                            area="Tecnologia";
                            areaV=false;
                            break;
                        case "4":
                            area="Calculo";
                            areaV=false;
                            break;
                        case "5":
                            area="Programacion";
                            areaV=false;
                            break;
                        default:
                            System.out.println("Ingrese una Opcion Coreecta");
                            break;
                    }                            
                    }
                while(areaV);
                Libro[n].Ingresar_Libro(nombre, autor, año, codigo, area, cantidad1);
                n++;
                System.out.println("Libro Ingresado Con Exito, Presione Enter para volver al Menu Anterior");
                teclado.nextLine();
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case "2":
                System.out.println("Ingrese el nombre del Libro que desea Actualizar");
                nombre=teclado.next();
                i=Names.indexOf(nombre);
                if(Libro[0].Actualizar_Libro(nombre))
                {
                    System.out.println("Ingrese el Nombre del Libro");
                    nombre=teclado.next();              
                    System.out.println("Ingrese El Autor del Libro");
                    autor=teclado.next();
                    System.out.println("Ingrese El año de Publicacion");
                    año=teclado.next();;
                    System.out.println("Ingrese el Codigo");
                    codigo=teclado.next();
                    System.out.println("Ingrese la Cantidad de libros");
                    cantidad=teclado.next();
                    cantidad1=Integer.parseInt(cantidad);
                    do
                {
                    System.out.println("Selccione el Area del Libro");
                    System.out.println("");
                    System.out.println("1.Qumica");
                    System.out.println("2.Fisica");
                    System.out.println("3.Tecnologia");
                    System.out.println("4.Calculo");
                    System.out.println("5.Programacion");
                    System.out.println("");
                    System.out.println("El Area del Libro es: ");
                    area=teclado.next();
                    switch (area)
                            {
                        case "1":
                            area="Qumica";
                            areaV=false;
                            break;
                        case "2":
                            area="Fisica";
                            areaV=false;
                            break;
                        case "3":
                            area="Tecnologia";
                            areaV=false;
                            break;
                        case "4":
                            area="Calculo";
                            areaV=false;
                            break;
                        case "5":
                            area="Programacion";
                            areaV=false;
                            break;
                        default:
                            System.out.println("Ingrese una Opcion Coreecta");
                            break;
                    }                            
                    }
                while(areaV);                    
                    Libro[i].Actualizar_Libro(nombre, autor, año, codigo, area, cantidad1,i);                    
                }
                else
                    System.out.println("El Libro NO exites, por favor Ingereselo Primero...");
                System.out.println("");
                System.out.println("Presione ENTER para volver al Menu ANterior.");
                teclado.nextLine();
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case "3":
                System.out.println("Ingrese el nombre del Libro que desea Eliminar");
                nombre=teclado.next();
                i=Names.indexOf(nombre); 
                if(i>-1)
                {
                    Libro[i].Eliminar_Libro(nombre);
                }
                else
                    Libro[i].Eliminar_Libro(nombre);
                System.out.println("Presione ENTER para volver al Menu ANterior.");
                teclado.nextLine();
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case "4":
                System.out.println("Ingrese el nombre del Libro que desea Buscar");
                nombre=teclado.next();
                if(Libro[0].Buscar_Libro(nombre))
                {
                    i=Names.indexOf(nombre);
                    Libro[i].Mostrar_datos();
                }
                else
                {
                    System.out.println("El Libro no Existe, Ingreselo Por favor Ingreselo");
                }
                System.out.println("Presione ENTER para volver al Menu ANterior.");
                teclado.nextLine();
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case "5":
                System.out.println("Ingrese el nombre del Libro que desea Prestar");
                nombre=teclado.next();
                String R="0";
                int a=0;
                i=Names.indexOf(nombre);
                if(i>-1)
                {
                    System.out.println("Esto son los datos del Libro");
                    System.out.println("");
                    Libro[i].Mostrar_datos();
                    System.out.println("");
                    System.out.println("Desea Prestar el Libro: ");
                    System.out.println("1.Si");
                    System.out.println("2.No");
                    R=teclado.next();
                    a=Integer.parseInt(R);
                    System.out.println("");
                    System.out.println("Ingrese el Numero de Su Cedula: ");
                    R=teclado.next();
                    System.out.println("");
                    System.out.println("Libro Prestado con Exito, Que lo Disfutes");
                }
                else
                   System.out.println("Este libro no exite en la Biblioteca");
                if(a==1)
                   Libro[i].Prestar_Libros(nombre,R);
                System.out.println("");
                System.out.println("Presione ENTER para volver al Menu ANterior.");
                teclado.nextLine();
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case "6":
                String Dev;
                System.out.println("Ingrese El Numero de la Cedula con la que el Libro esta Regitrado");
                Dev=teclado.next();
                System.out.println("");
                Libro[0].Devolver_Libros(Dev);
                teclado.nextLine();
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case "7":
                Libro[0].Libros_Prestados();
                System.out.println("Presione ENTER para volver al Menu ANterior.");
                teclado.nextLine();
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case "8":
                salir=false;
                break;
            default:
                System.out.println("Ingrese una Opcion Coreecta"); 
                break;                    
        }
        }
        while(salir);
    }
    
}
