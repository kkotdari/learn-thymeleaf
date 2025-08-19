showRewardConvertHistoryList = async (affiliateId, currPage, pageSize, currOrder) => {
    const params = new URLSearchParams({
        currPage: currPage,
        pageSize: pageSize,
        currOrder: currOrder
    })
    const res = await fetch(`affiliates/rewards/histories/affiliate/${affiliateId}?${params.toString()}`)
    const el = document.getElementById('affiliate-reward-convert-history-list')
    el.outerHTML = await res.text()
}