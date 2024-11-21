import java.util.Scanner;
public class HealthMate {
            // **la contraseña del modo administrador es 7714**
    static class Paciente {
        String nombre;
        String apellido;
        int peso;
        int altura;
        int edad;
        String sexo;

        Paciente(String nombreParam, String apellidoParam, int pesoParam, int alturaParam, int edadParam, String sexoParam) {
            nombre = nombreParam;
            apellido = apellidoParam;
            peso = pesoParam;
            altura = alturaParam;
            edad = edadParam;
            sexo = sexoParam;
        }
    }

    static class SistemaMedico {
        Paciente[] pacientes;
        int contadorPacientes;

        SistemaMedico(int maxPacientes) {
            pacientes = new Paciente[maxPacientes];
            contadorPacientes = 0;
        }

        boolean registrarPaciente(String nombreParam,
                                  String apellidoParam,
                                  int pesoParam,
                                  int alturaParam,
                                  int edadParam,
                                  String sexoParam) {
            if (contadorPacientes < pacientes.length) {
                pacientes[contadorPacientes] = new Paciente(nombreParam, apellidoParam, pesoParam, alturaParam, edadParam, sexoParam);
                contadorPacientes++;
                return true;
            } else {
                return false;
            }
        }

        Paciente buscarPaciente(String nombreParam, String apellidoParam) {
            for (int i = 0; i < contadorPacientes; i++) {
                if (pacientes[i] != null &&
                        pacientes[i].nombre.equalsIgnoreCase(nombreParam) &&
                        pacientes[i].apellido.equalsIgnoreCase(apellidoParam)) {
                    return pacientes[i];
                }
            }
            return null;
        }

        void mostrarTodosLosPacientes() {
            if (contadorPacientes == 0) {
                System.out.println("No hay pacientes registrados.");
                return;
            }
            System.out.println("Lista de pacientes:");
            for (int i = 0; i < contadorPacientes; i++) {
                Paciente paciente = pacientes[i];
                System.out.printf("%d. %s %s - Edad: %d, Peso: %dkg, Altura: %dcm, Sexo: %s\n",
                        i + 1, paciente.nombre,
                                paciente.apellido,
                                paciente.edad,
                                paciente.peso,
                                paciente.altura,
                                paciente.sexo);
            }
        }


        void eliminarPaciente(String nombre, String apellido) {
            for (int i = 0; i < contadorPacientes; i++) {
                if (pacientes[i] != null && pacientes[i].nombre.equalsIgnoreCase(nombre) && pacientes[i].apellido.equalsIgnoreCase(apellido)) {
                    pacientes[i] = null;

                    for (int j = i; j < contadorPacientes - 1; j++) {
                        pacientes[j] = pacientes[j + 1];
                    }

                    pacientes[contadorPacientes - 1] = null;
                    contadorPacientes--;
                    System.out.println("Paciente eliminado exitosamente.");
                    return;
                }
            }
            System.out.println("Paciente no encontrado.");
        }

                // *clase principal del proyecto* .
             public static void main(String[] args) {
               SistemaMedico sistema = new SistemaMedico(12);
                    Scanner Input = new Scanner(System.in);
                    String CONTRASENA_ADMIN = "7714";

            while (true) {
                  System.out.println("Bienvenido a Heath Mate");
                   System.out.println("Porfavor seleccione una opción:");
                    System.out.println("1. Ingresar");
                  System.out.println("2. Registrar");
                  System.out.println("3. Modo Administrador");
                    System.out.println("4. Salir");

                int opcion = Input.nextInt();
                Input.nextLine();

                if (opcion == 1) {
                    System.out.print("Ingrese nombre: ");
                    String nombreParam = Input.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellidoParam = Input.nextLine();

                    Paciente paciente = sistema.buscarPaciente(nombreParam, apellidoParam);
                    if (paciente != null)  {
                        System.out.println("Ingreso exitoso. Bienvenido, " + paciente.nombre);
                        while (true) {
                            System.out.println("Menú del Paciente:");
                            System.out.println("1-Calculadora de peso ideal");
                             System.out.println("2-Calculadora de dosis médica");
                             System.out.println("3-Calcular calorías diarias");
                             System.out.println("4-Medir frecuencia cardíaca ideal para ejercicio");
                             System.out.println("5-Calcular consumo de agua diaria");
                             System.out.println("6-Modificar datos pacientes");
                             System.out.println("7-Salir al menú principal");

                            int opcionPaciente = Input.nextInt();
                                Input.nextLine();

                               if (opcionPaciente == 1) {
                                calculadoraPesoIdeal(paciente);
                            } else if (opcionPaciente == 2) {
                                calculadoraDosis(paciente);
                            } else if (opcionPaciente == 3) {
                                  calcularCaloriasDiarias(paciente) ;
                            }if (opcionPaciente == 4) {
                                frecuenciaCardiacaIdeal(paciente);
                            } else if (opcionPaciente == 5) {
                                 calculadoraAguaDiaria(paciente);
                            } else if (opcionPaciente == 6) {
                                modificarDatosPaciente(paciente);

                            } else if (opcionPaciente == 7) {
                                System.out.println("Saliendo al menú principal");
                                break;
                            } else {
                                System.out.println("Seleccione otra opcion porfavor");
                            }
                        }
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }

                } else if (opcion == 2) {
                    System.out.print("Ingrese nombre: ");
                    String nombreParam = Input.nextLine();
                     System.out.print("Ingrese apellido: ");
                      String apellidoParam = Input.nextLine();
                    System.out.print("Ingrese peso (kg): ");
                     int pesoParam = Input.nextInt();
                    System.out.print("Ingrese altura (cm, sin coma): ");
                    int alturaParam = Input.nextInt();
                    System.out.print("Ingrese edad: ");
                    int edadParam = Input.nextInt();
                     Input.nextLine();
                    System.out.print("Ingrese sexo (Masculino/Femenino): ");
                    String sexoParam = Input.nextLine();

                    if (sistema.registrarPaciente(nombreParam, apellidoParam, pesoParam, alturaParam, edadParam, sexoParam)) {
                        System.out.println("Registro exitoso.");
                    } else {
                        System.out.println("No se puede registrar más pacientes, lista llena.");}

                } else if (opcion == 3) {
                    System.out.print("Ingrese la contraseña de administrador: ");
                    String contrasena = Input.nextLine();
                     if (contrasena.equals(CONTRASENA_ADMIN)) {
                        System.out.println("Modo administrador activado.");
                        while (true) {
                            System.out.println("Opciones de Administrador:");
                            System.out.println("1. Ver todos los pacientes");
                            System.out.println("2. Eliminar paciente");
                            System.out.println("3. Salir del modo administrador");

                            int opcionAdmin = Input.nextInt();
                            Input.nextLine();

                            if (opcionAdmin == 1) {
                                sistema.mostrarTodosLosPacientes();

                            } else if (opcionAdmin == 2) {
                                System.out.print("Ingrese nombre del paciente a eliminar: ");
                                String nombreEliminar =Input.nextLine();
                                System.out.print("Ingrese apellido del paciente a eliminar: ");
                                String apellidoEliminar = Input.nextLine();

                                sistema.eliminarPaciente(nombreEliminar, apellidoEliminar);

                            } else if (opcionAdmin == 3) {
                                System.out.println("Saliendo del modo administrador...");
                                break;
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        }
                    } else {
                        System.out.println("Contraseña incorrecta. Acceso denegado.");
                    }

                } else if (opcion == 4) {
                    System.out.println("Saliendo del sistema...");
                    break;
                } else {
                    System.out.println("Opción inválida.");
                }
            }

        }

        public static void calculadoraPesoIdeal(Paciente paciente) {
            double pesoIdealMin;
            double pesoIdealMax;
            double pesoIdealPromedio;


            if (paciente.sexo.equalsIgnoreCase("Masculino")) {
                 pesoIdealMin = 50 + 0.91 * (paciente.altura - 152) - 5;
                   pesoIdealMax = 50 + 0.91 * (paciente.altura - 152) + 5;
             } else if (paciente.sexo.equalsIgnoreCase("Femenino")) {
                   pesoIdealMin = 45.5 + 0.91 * (paciente.altura - 152) - 5;
                  pesoIdealMax = 45.5 + 0.91 * (paciente.altura - 152) + 5;
            } else {
                System.out.println("Sexo no reconocido. No se puede calcular el peso ideal.");
                return;
            }

            pesoIdealPromedio = (pesoIdealMin + pesoIdealMax) / 2;


            double diferencia = paciente.peso - pesoIdealPromedio;
            int caloriasRecomendadas;
            String evaluacion;

            if (diferencia > 10) {
                evaluacion = "sobrepeso significativo";
                caloriasRecomendadas = -1500;
            } else if (diferencia > 5) {
                evaluacion = "ligero sobrepeso";
                caloriasRecomendadas = -500;
            } else if (diferencia < -10) {
                evaluacion = "bajo peso significativo";
                caloriasRecomendadas = 1500;
            } else if (diferencia < -5) {
                evaluacion = "ligero bajo peso";
                caloriasRecomendadas = 500;
            } else {
                evaluacion = "peso dentro del rango ideal";
                caloriasRecomendadas = 0;
            }


            System.out.printf(
                    "El rango de peso ideal para %s %s es %.2f - %.2f kg.\n",
                    paciente.nombre, paciente.apellido, pesoIdealMin, pesoIdealMax);
            System.out.printf(
                    "Actualmente está en un estado de %s.\n",
                    evaluacion);
            if (caloriasRecomendadas != 0) {
                System.out.printf(
                        "Se recomienda ajustar su consumo diario en %d calorías.\n",
                        Math.abs(caloriasRecomendadas));
            } else {
                System.out.println("No se requiere ajuste calórico.");
            }
        }
        public static void calculadoraDosis(Paciente paciente) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Seleccione un medicamento para calcular la dosis:");
            System.out.println("1. Paracetamol");
            System.out.println("2. Ibuprofeno");
            System.out.println("3. Amoxicilina");
            System.out.println("4. Aspirina");
            System.out.println("5. Diclofenaco");
            System.out.println("6. Loratadina");

            int opcionMedicamento = scanner.nextInt();
            scanner.nextLine();

            double dosisPorKg = 0;
            double dosisMaxima = 0;
            switch (opcionMedicamento) {
                case 1:
                    dosisPorKg = 10;
                    dosisMaxima = 4000;
                    break;
                case 2:
                    dosisPorKg = 5;
                    dosisMaxima = 2400;
                    break;
                case 3:
                    dosisPorKg = 25;
                    dosisMaxima = 3000;
                    break;
                case 4:
                    dosisPorKg = 10;
                    dosisMaxima = 4000;
                    break;
                case 5:
                    dosisPorKg = 2;
                    dosisMaxima = 150;
                    break;
                case 6:
                    dosisPorKg = 0.2;
                    dosisMaxima = 10;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    return;
            }


            double dosisTotal = dosisPorKg * paciente.peso;


            if (dosisTotal > dosisMaxima) {
                dosisTotal = dosisMaxima;
            }

            System.out.printf("Dosis recomendada para %s %s: %.2f mg\n", paciente.nombre, paciente.apellido, dosisTotal);
            System.out.printf("Dosis máxima diaria recomendada para este medicamento: %.2f mg\n", dosisMaxima);
        }
        }
        public static void calcularCaloriasDiarias(Paciente paciente) {
            double tmb;
                             //*Fórmula de Harris-Benedict*
               if (paciente.sexo.equalsIgnoreCase("Masculino")) {
                    tmb = 88.362 + (13.397 * paciente.peso) + (4.799 * paciente.altura) - (5.677 * paciente.edad);
                   } else if (paciente.sexo.equalsIgnoreCase("Femenino")) {
                   tmb = 447.593 + (9.247 * paciente.peso) + (3.098 * paciente.altura) - (4.330 * paciente.edad);
                   } else {
                   System.out.println("Sexo no reconocido. No se puede calcular el TMB.");
                  return;
                     }


                     Scanner scanner = new Scanner(System.in);
                    System.out.println("Seleccione su nivel de actividad:");
                    System.out.println("1. Sedentario (poco o ningún ejercicio)");
                     System.out.println("2. Normal (ejercicio moderado)");
                    System.out.println("3. Activo (ejercicio intenso)");

            int opcionActividad = scanner.nextInt();
            double factorActividad = 1.0;

            switch (opcionActividad) {
                case 1:
                    factorActividad = 1.2;
                    break;
                case 2:
                    factorActividad = 1.55;
                    break;
                case 3:
                    factorActividad = 1.9;
                    break;
                default:
                    System.out.println("Opción inválida, se asignará un factor de actividad normal.");
                    factorActividad = 1.55;
                    break;
              }
            double caloriasMantenimiento = tmb * factorActividad;
            System.out.printf("Las calorías diarias recomendadas para mantenimiento son: %.2f calorías.\n", caloriasMantenimiento);
          }
        public static void frecuenciaCardiacaIdeal(Paciente paciente) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese su frecuencia cardíaca en reposo (latidos por minuto): ");
            int frecuenciaReposo = scanner.nextInt();

            int frecuenciaMaxima = 220 - paciente.edad;

            System.out.println("Seleccione la intensidad del ejercicio:");
            System.out.println("1. Ligera (50%)");
            System.out.println("2. Moderada (70%)");
            System.out.println("3. Intensa (85%)");

            int opcionIntensidad = scanner.nextInt();
            double intensidad = 0.5;

            switch (opcionIntensidad) {
                case 1:
                    intensidad = 0.5;
                    break;
                case 2:
                    intensidad = 0.7;
                    break;
                case 3:
                    intensidad = 0.85;
                    break;
                default:
                    System.out.println("Opción inválida, se usará intensidad moderada (70%).");
                    intensidad = 0.7;
             }

            int frecuenciaEjercicio = (int) (frecuenciaReposo + (frecuenciaMaxima - frecuenciaReposo) * intensidad);

            System.out.printf(
                    "Para un ejercicio con intensidad del %.0f%%, su frecuencia cardíaca ideal para su edad es: %d latidos por minuto.\n",
                    intensidad * 100, frecuenciaEjercicio);
    }

        public static void calculadoraAguaDiaria(Paciente paciente) {
            double litrosDiarios = paciente.peso * 35.0 / 1000;
            System.out.printf(//meduelelacabeza
                    "%s %s, para su peso (%d kg), se recomienda beber aproximadamente %.2f litros de agua al día.\n",
                    paciente.nombre, paciente.apellido, paciente.peso, litrosDiarios);
           }
        public static void modificarDatosPaciente(Paciente paciente) {
            Scanner scanner = new Scanner(System.in);

             System.out.println("Modificando datos del paciente...");
             System.out.printf("Nombre actual: %s\nNuevo nombre: ", paciente.nombre);
            paciente.nombre = scanner.nextLine();

              System.out.printf("Apellido actual: %s\nNuevo apellido: ", paciente.apellido);
            paciente.apellido = scanner.nextLine();

               System.out.printf("Peso actual: %d kg\nNuevo peso (en kg): ", paciente.peso);
            paciente.peso = scanner.nextInt();

               System.out.printf("Altura actual: %d cm\nNueva altura (en cm): ", paciente.altura);
               paciente.altura = scanner.nextInt();

               System.out.printf("Edad actual: %d\nNueva edad: ", paciente.edad);
              paciente.edad = scanner.nextInt();
              scanner.nextLine();
                System.out.printf("Sexo actual: %s\nNuevo sexo (Masculino/Femenino): ", paciente.sexo);
                  paciente.sexo = scanner.nextLine();

            System.out.println("Los datos del paciente han sido actualizados exitosamente.");
        }

    }


