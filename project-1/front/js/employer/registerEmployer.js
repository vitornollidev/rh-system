function registerEmployer(name, email, role, department){

      $.ajax({
            url: "http://localhost:8080/users",
            method: "POST",
            dataType: "JSON",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                name: name,
                email: email,
                role:{
                    id: role
                },
                department:{
                    id: department
                }
            }),
            success: function(response){
                $('#modal-register').modal('hide');
                $('#modal-title').text("Registrado");
                $("#p-modal-body").text("Colaborador cadastrado com sucesso!");
                $("#modal-information").modal('show');
                setTimeout(function() {
                    $('#modal-information').modal('hide');
                    window.location.reload();
                }, 1500);
            },
            error: function(response){
                console.log("Erro ao inserir: " + response);
            }
      })
}