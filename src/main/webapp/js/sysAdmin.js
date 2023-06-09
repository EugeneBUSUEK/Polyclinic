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

const actionFormEl = document.getElementById('actionForm')

const usernameActionInputEl = actionFormEl.querySelector('input[name="username"]');
const nameActionInputEl = actionFormEl.querySelector('input[name="name"]');
const passwordActionInputEl = actionFormEl.querySelector('input[name="password"]');
const specActionInputEl = actionFormEl.querySelector('input[name="spec"]');
const cabinetActionInputEl = actionFormEl.querySelector('input[name="cabinet"]');
const idActionInputEl = actionFormEl.querySelector('input[name="id"]');
const roleActionInputEl = actionFormEl.querySelector('input[name="role"]');

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

        idActionInputEl.value = idInputEl.value
        usernameActionInputEl.value = usernameInputEl.value
        passwordActionInputEl.value = passwordInputEl.value
        nameActionInputEl.value = nameInputEl.value


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
                specActionInputEl.value = spec
                cabinetActionInputEl.value = cabinet
                break
            }
        }
    }
})

function doctorRbOnClick(){
    roleInputEl.value = 'Doctor'
    roleActionInputEl.value = 'doctor'
    document.getElementById('doctorFormEditForm').style.display = 'flex'
};

function moderRbOnClick(){
    roleInputEl.value = 'Moderator'
    roleActionInputEl.value = 'moderator'
    document.getElementById('doctorFormEditForm').style.display = 'none'
    specInputEl.value = ''
    cabinetInputEl.value = ''
};

function sysAdminRbOnClick(){
    roleInputEl.value = 'System Administrator'
    roleActionInputEl.value = 'system_administrator'
    document.getElementById('doctorFormEditForm').style.display = 'none'
    specInputEl.value = ''
    cabinetInputEl.value = ''
};

function polycAdminRbOnClick(){
    roleInputEl.value = 'Polyclinic Administrator'
    roleActionInputEl.value = 'polyclinic_administrator'
    document.getElementById('doctorFormEditForm').style.display = 'none'
    specInputEl.value = ''
    cabinetInputEl.value = ''
};

function dataToAction(){
    document.getElementById('requiredEdit').click()
    idActionInputEl.value = idInputEl.value
    usernameActionInputEl.value = usernameInputEl.value
    passwordActionInputEl.value = passwordInputEl.value
    nameActionInputEl.value = nameInputEl.value
    specActionInputEl.value = specInputEl.value
    cabinetActionInputEl.value = cabinetInputEl.value
}

const addFormEl = document.getElementById('addForm');

const usernameAddInputEl = addFormEl.querySelector('input[id="username"]');
const nameAddInputEl = addFormEl.querySelector('input[id="name"]');
const passwordAddInputEl = addFormEl.querySelector('input[id="password"]');
const specAddInputEl = addFormEl.querySelector('input[id="spec"]');
const cabinetAddInputEl = addFormEl.querySelector('input[id="cabinet"]');
const roleAddInputEl = addFormEl.querySelector('input[id="role"]');

const doctorAddRbEl = addFormEl.querySelector('#doctorRB');
const moderatorAddRbEl = addFormEl.querySelector('#moderRB');
const sysAdminAddRbEl = addFormEl.querySelector('#sysAdminRB');
const polycAdminAddRbEl = addFormEl.querySelector('#polycAdminRB');

const actionFormAddEl = document.getElementById('actionAddForm')

const usernameActionAddInputEl = actionFormAddEl.querySelector('input[name="username"]');
const nameActionAddInputEl = actionFormAddEl.querySelector('input[name="name"]');
const passwordActionAddInputEl = actionFormAddEl.querySelector('input[name="password"]');
const specActionAddInputEl = actionFormAddEl.querySelector('input[name="spec"]');
const cabinetActionAddInputEl = actionFormAddEl.querySelector('input[name="cabinet"]');
const roleActionAddInputEl = actionFormAddEl.querySelector('input[name="role"]');

function doctorRbAddOnClick(){
    roleAddInputEl.value = 'Doctor'
    roleActionAddInputEl.value = 'doctor'
    document.getElementById('doctorFormAddForm').style.display = 'flex'
};

function moderRbAddOnClick(){
    roleAddInputEl.value = 'Moderator'
    roleActionAddInputEl.value = 'moderator'
    document.getElementById('doctorFormAddForm').style.display = 'none'
};

function sysAdminRbAddOnClick(){
    roleAddInputEl.value = 'System Administrator'
    roleActionAddInputEl.value = 'system_administrator'
    document.getElementById('doctorFormAddForm').style.display = 'none'
};

function polycAdminRbAddOnClick(){
    roleAddInputEl.value = 'Polyclinic Administrator'
    roleActionAddInputEl.value = 'polyclinic_administrator'
    document.getElementById('doctorFormAddForm').style.display = 'none'
};

function dataToActionAdd(){
    document.getElementById('requiredAdd').click()
    usernameActionAddInputEl.value = usernameAddInputEl.value
    passwordActionAddInputEl.value = passwordAddInputEl.value
    nameActionAddInputEl.value = nameAddInputEl.value
    specActionAddInputEl.value = specAddInputEl.value
    cabinetActionAddInputEl.value = cabinetAddInputEl.value
};