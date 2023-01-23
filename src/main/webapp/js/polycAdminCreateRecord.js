const checkFormEl = document.getElementById('checkForm');

const patientNameInputEl = checkFormEl.querySelector('input[id="paietntName"]');
const patientPhoneInputEl = checkFormEl.querySelector('input[id="patientPhone"]');
const doctorNameInputEl = checkFormEl.querySelector('input[id="doctorName"]');
const doctorSpecInputEl = checkFormEl.querySelector('input[id="doctorSpec"]');

const actionFormEl = document.getElementById('actionForm');

const patientNameActionInputEl = actionFormEl.querySelector('input[name="patient_name"]');
const patientPhoneActionInputEl = actionFormEl.querySelector('input[name="phone"]');
const doctorNameActionInputEl = actionFormEl.querySelector('input[name="doctor_name"]');
const doctorSpecActionInputEl = actionFormEl.querySelector('input[name="spec"]');
const patientIdActionInputEl = actionFormEl.querySelector('input[name="patient_id"]');
const doctorIdActionInputEl = actionFormEl.querySelector('input[name="doctor_id"]');

[...document.querySelectorAll('input[value="Record"]')].forEach(editBtnEl => {
    editBtnEl.onclick = () => {
        document.getElementById('doctorList').style.display = 'flex'

        const rowEl = editBtnEl.closest("tr")

        const patientName = rowEl.querySelector('.patient_name').innerText.trim()
        const patientPhone = rowEl.querySelector('.patient_phone').innerText.trim()
        const patientId = rowEl.querySelector('.patient_id').innerText.trim()

        patientNameInputEl.value = patientName
        patientPhoneInputEl.value = patientPhone

        patientNameActionInputEl.value = patientName
        patientPhoneActionInputEl.value = patientPhone
        patientIdActionInputEl.value = patientId

    }
});

[...document.querySelectorAll('input[value="Appointments"]')].forEach(editBtnEl => {
    editBtnEl.onclick = () => {
        document.getElementById('checkForm').style.display = 'flex'

        const rowEl = editBtnEl.closest("tr")

        const doctorName = rowEl.querySelector('.doctor_name').innerText.trim()
        const doctorSpec = rowEl.querySelector('.doctor_spec').innerText.trim()
        const doctorId = rowEl.querySelector('.doctor_id').innerText.trim()

        doctorNameInputEl.value = doctorName
        doctorSpecInputEl.value = doctorSpec

        doctorNameActionInputEl.value = doctorName
        doctorSpecActionInputEl.value = doctorSpec
        doctorIdActionInputEl.value = doctorId

    }
});