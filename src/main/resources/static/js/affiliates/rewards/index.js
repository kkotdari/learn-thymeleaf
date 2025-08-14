filterRewardConvertHistoryList = async (id) => {
    console.log('filterRewardConvertHistoryList > id: ', id)
    const res = await fetch('affiliates/rewards/histories/affiliate/' + id)
    const el = document.getElementById('affiliate-reward-convert-history-list')
    console.log('#affiliate-reward-convert-history-list: ', el)
    el.outerHTML = await res.text()
}