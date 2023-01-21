// for Add User button
function displayAddForm(){
    if (document.getElementById('editForm').style.display === 'flex'){
        document.getElementById('editForm').style.display = 'none'
    }
    document.getElementById('addForm').style.display='flex'
}

function closeAddForm(){
    document.getElementById('addForm').style.display='none'
}

function closeEditForm(){
    document.getElementById('editForm').style.display='none'
}

