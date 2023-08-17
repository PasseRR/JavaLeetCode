SELECT ROUND(COUNT(IF(`order_date` = `customer_pref_delivery_date`, 1, NULL)) * 100 / COUNT(1), 2) `immediate_percentage`
FROM `Delivery`
