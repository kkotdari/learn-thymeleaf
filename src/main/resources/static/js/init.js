initListeners = (path) => {
    console.log('initListeners > path: ', path)
    switch (path) {
        case 'auth/login':
            document.getElementById('login-form').addEventListener('submit', function (e) {
                    e.preventDefault()

                    const form = e.target
                    const formData = new FormData(form)

                    fetch('/auth/login', {
                        method: 'POST',
                        body: formData
                    })
                        .then(res => {
                            if (!res.ok) {
                                throw new Error('Login failed')
                            }
                            return res.text()
                        })
                        .then(html => {
                            document.getElementById('content-container').innerHTML = html
                        })
                        .catch(err => {
                            console.error('auth > login > login error: ', err)
                        })
                }
            )
            break

        case 'auth/signup':
            document.getElementById('signup-form').addEventListener('submit', function (e) {
                    e.preventDefault()

                    const form = e.target
                    const formData = new FormData(form)

                    fetch('auth/signup', {
                        method: 'POST',
                        body: formData
                    })
                        .then(res => {
                            if (!res.ok) {
                                throw new Error('Signup failed')
                            }
                            return res.text()
                        })
                        .then(html => {
                            document.getElementById('content-container').innerHTML = html
                        })
                        .catch(err => {
                            console.error('auth > signup > signup error: ', err)
                        })
                }
            )
            break
    }
}

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