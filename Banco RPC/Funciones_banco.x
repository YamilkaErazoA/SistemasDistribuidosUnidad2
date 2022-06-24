struct mensaje{
    int seleccion;
    int dinero;
};

program FUNCIONES_BANCO{
    version VERSION_MENSAJE{
        string msj (mensaje) = 1;
    } = 1;
} = 0x20000001;
