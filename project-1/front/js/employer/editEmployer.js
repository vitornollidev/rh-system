function editEmployerById(id, name, email, departmentId){
    $.ajax({
        url: "http://localhost:8080/users/edit/" + id,
        method: "put",
        dataType: "JSON",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
                id: id,
                name: name,
                email: email,
                department: {
                    id: departmentId
                },
        }),
        success: function(response){
            $('#modal-edit-employer').modal('hide');
            $('#modal-title').text("Editado!");
            $("#p-modal-body").text("Colaborador editado com sucesso!");
            $("#modal-information").modal('show');
            setTimeout(function() {
                $('#modal-information').modal('hide');
                    window.location.reload();
            }, 1500);
        },
        error: function(xhr, status, error) {
            $('#modal-edit-employer').modal('hide');
            $('#modal-title').text("Erro!");
            $("#p-modal-body").text("Erro ao editar colaborador!" + error);
            $("#modal-information").modal('show');
            setTimeout(function() {
                $('#modal-information').modal('hide');
                    window.location.reload();
            }, 3000);
        }
        
    })
}