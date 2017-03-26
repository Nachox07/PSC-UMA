cmake_minimum_required(VERSION 3.6)
project(Practica_Drone)

set(CMAKE_C_STANDARD 11)

set(SOURCE_FILES
        src/practica1.c src/gestion_memoria.c src/arbolbb.h src/arbolbb.c)
add_executable(Practica_Drone ${SOURCE_FILES})