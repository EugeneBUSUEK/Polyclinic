[...document.querySelectorAll('input[value="check"]')].forEach(editBtEl => {
    editBtEl.onclick = () => {
        const rowEl = editBtEl.closest("tr")

        const fromTime = rowEl.querySelector('input[name="timefrom"]').innerText.trim()
        const toTime = rowEl.querySelector('input[name="timeto"]').innerText.trim()

        const actionForm = rowEl.getElementById('actionForm')

        const fromInputAction = actionForm.querySelector('input[name="from_time"]')
        const toInputAction = actionForm.querySelector('input[name="to_time"]')

        fromInputAction.value = 12
        toInputAction.value = toTime
    }
});

// document.getElementById('timefrom').value = '14:54'