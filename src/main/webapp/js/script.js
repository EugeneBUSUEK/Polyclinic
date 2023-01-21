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

function displayDoctorFormAdd() {
    document.getElementById('doctorFormAddForm').style.display = 'flex'
}

function hiddenDoctorFormAdd() {
    document.getElementById('doctorFormAddForm').style.display = 'none'
}

function displayDoctorFormEdit() {
    document.getElementById('doctorFormEditForm').style.display = 'flex'
}

function hiddenDoctorFormEdit() {
    document.getElementById('doctorFormEditForm').style.display = 'none'
}

const editFormEl = document.querySelector('#edit-form');

const usernameInputEl = editFormEl.querySelector('input[id="username"]');
const nameInputEl = editFormEl.querySelector('input[id="name"]');
const passwordInputEl = editFormEl.querySelector('input[id="password"]');
const specInputEl = editFormEl.querySelector('input[id="spec"]');
const cabinetInputEl = editFormEl.querySelector('input[id="cabinet"]');
const idInputEl = editFormEl.querySelector('input[id="id"]');
const roleInputEl = editFormEl.querySelector('input[id="role"]');

const doctorRbEl = editFormEl.querySelector('#doctorRB');
const moderatorRbEl = editFormEl.querySelector('#moderRB');
const sysAdminRbEl = editFormEl.querySelector('#sysAdminRB');
const polycAdminRbEl = editFormEl.querySelector('#polycAdminRB');

[...document.querySelectorAll('input[value="Edit"]')].forEach(editBtnEl => {
    editBtnEl.onclick = () => {

        if (document.getElementById('addForm').style.display === 'flex'){
            document.getElementById('addForm').style.display='none'
        }

        document.getElementById('editForm').style.display='flex'

        const rowEl = editBtnEl.closest("tr")

        const username = rowEl.querySelector('.username').innerText.trim()
        const name = rowEl.querySelector('.name').innerText.trim()
        const role = rowEl.querySelector('.role').innerText.trim()
        const password = rowEl.querySelector('.password').innerText.trim()
        const spec = rowEl.querySelector('.specialization').innerText.trim()
        const cabinet = rowEl.querySelector('.cabinet').innerText.trim()
        const id = rowEl.querySelector('.id').innerText.trim()

        usernameInputEl.value = username
        passwordInputEl.value = password
        nameInputEl.value = name
        idInputEl.value = id
        roleInputEl.value = role



        switch (role) {
            case 'Moderator': {
                moderatorRbEl.click()

                specInputEl.value = ''
                cabinetInputEl.value = ''
                break
            }
            case 'System Administrator': {
                sysAdminRbEl.click()

                specInputEl.value = ''
                cabinetInputEl.value = ''
                break
            }
            case 'Polyclinic Administrator': {
                polycAdminRbEl.click()

                specInputEl.value = ''
                cabinetInputEl.value = ''
                break
            }
            case 'Doctor': {
                doctorRbEl.click()

                specInputEl.value = spec
                cabinetInputEl.value = cabinet
                break
            }
        }
    }
})

const actionFormEl = document.getElementById('actionForm')
const addUserActionFormEl = document.getElementById('addUserAction')


const usernameActionInputEl = actionFormEl.querySelector('input[name="username"]');
const nameActionInputEl = actionFormEl.querySelector('input[name="name"]');
const passwordActionInputEl = actionFormEl.querySelector('input[name="password"]');
const specActionInputEl = actionFormEl.querySelector('input[name="specialization"]');
const cabinetActionInputEl = actionFormEl.querySelector('input[name="cabinet"]');
const idActionInputEl = actionFormEl.querySelector('input[name="id"]');
const roleActionInputEl = actionFormEl.querySelector('input[name="role"]');

const usernameAddActionInputEl = addUserActionFormEl.querySelector('input[name="username"]');
const passwordAddActionInputEl = addUserActionFormEl.querySelector('input[name="username"]');
const nameAddActionInputEl = addUserActionFormEl.querySelector('input[name="username"]');
const roleAddActionInputEl = addUserActionFormEl.querySelector('input[name="username"]');
const specAddActionInputEl = addUserActionFormEl.querySelector('input[name="username"]');
const cabinetAddActionInputEl = addUserActionFormEl.querySelector('input[name="username"]');


function dataToAction(){
    idActionInputEl.value = idInputEl.value
    usernameActionInputEl.value = usernameInputEl.value
    passwordActionInputEl.value = passwordInputEl.value
    nameActionInputEl.value = nameInputEl.value
    specActionInputEl.value = specInputEl.value
    cabinetActionInputEl.value = cabinetInputEl.value
    roleActionInputEl.value = roleInputEl.value
};

const addFormEl = document.getElementById('addForm')



function dataToActionAdd(){
    idActionInputEl.value = idInputEl.value
    usernameActionInputEl.value = usernameInputEl.value
    passwordActionInputEl.value = passwordInputEl.value
    nameActionInputEl.value = nameInputEl.value
    specActionInputEl.value = specInputEl.value
    cabinetActionInputEl.value = cabinetInputEl.value
    roleActionInputEl.value = roleInputEl.value
}