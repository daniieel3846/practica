function eliminar(id){
    swal({
      title: "Estas seguro de Eliminar?",
      text: "Una vez borrado no podras recuperar el registro!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((OK) => {
      if (OK) {
        $.ajax({
            url: "/productos/eliminar/"+id,
            success: function(res){
                console.log(res);
            }
        });
        swal("Registro Borrado con exito!", {
          icon: "success",
        }).then((ok)=>{
           if(ok){
              location.href="/productos";
           }
        });
      } else {
        swal("No se borro ningun registro!");
      }
    });
}