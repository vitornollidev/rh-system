function deleteEmployerById(id){
    $.ajax({
        url: "http://localhost:8080/users/delete/" + id,
        method: "delete",
        success: function(response){
            $('#modal-delete-employer').modal('hide');
            $('#modal-title').text("Deletado!");
            $("#p-modal-body").text("Colaborador deletado com sucesso!");
            $("#modal-information").modal('show');
            setTimeout(function() {
                $('#modal-information').modal('hide');
                    window.location.reload();
            }, 1500);
        },
        error: function(xhr, status, error) {
            $('#modal-delete-employer').modal('hide');
            $('#modal-title').text("Erro!");
            $("#p-modal-body").text("Erro ao deletar colaborador!" + error);
            $("#modal-information").modal('show');
            setTimeout(function() {
                $('#modal-information').modal('hide');
                    window.location.reload();
            }, 3000);
        }
        
    })
}