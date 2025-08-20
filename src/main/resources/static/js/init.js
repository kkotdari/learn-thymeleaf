initFlatpickr = () => {
    if (typeof flatpickr !== 'function') {
        console.warn("flatpickr is not loaded")
        return
    }

    console.log('initFlatpickr called')

    const startEls = document.querySelectorAll('.common-date-input-flatpickr.start-date')
    const endEls = document.querySelectorAll('.common-date-input-flatpickr.end-date')

    startEls.forEach(startEl => {
        if (startEl) {
            flatpickr(startEl, {
                dateFormat: "Y-m-d",
                onChange: function (selectedDates, dateStr) {
                    const formatted = dayjs(dateStr).format("YYYY년 MM월 DD일")
                    console.log("선택된 시작 날짜:", formatted)
                }
            })
        }
    })

    endEls.forEach(endEl => {
        if (endEl) {
            flatpickr(endEl, {
                dateFormat: "Y-m-d",
                onChange: function (selectedDates, dateStr) {
                    const formatted = dayjs(dateStr).format("YYYY년 MM월 DD일")
                    console.log("선택된 종료 날짜:", formatted)
                }
            })
        }
    })
}