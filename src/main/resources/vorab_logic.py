#make GET request to Hubspot API amd for the given contact email get the following: 

hubspot_country = get.country_hubspot
hubspot_industry = get.industry_hubspot
order_value = get.order_value_hubspot
loan_length = get.loan_length_hubspot

#from your own DB get the following via query or api 

country_risk_premium = "select country_risk_premium from country_risk_premiums where country = hubspot_country"
country_equity_risk_premium = "select total_equity_risk_premium from country_risk_premiums where country = hubspot_country"
industry_beta = "select levered_beta from industry_betas where ((industry_name = hubspot_industry) or (eh_equivalent_industry_name_germany = hubspot_industry))"
debt_beta_min = 0.296 #constants
debt_beta_max = 0.41 #constants


#calculating industry risk 
industry_risk_interest_min = (((country_equity_risk_premium - country_risk_premium)*industry_beta*debt_beta_min) *0.15) #15% weight for industry risk
industry_risk_interest_max = (((country_equity_risk_premium - country_risk_premium)*industry_beta*debt_beta_max) *0.15) #15% weight for industry risk
country_risk_interest = (country_risk_premium*0.15) #15% weight for country risk

#calculating 30% country and industry interest rate
interst_per_factor_min = country_risk_interest + industry_risk_interest_min
interst_per_factor_max = country_risk_interest + industry_risk_interest_max


best_rating = (0.05*0.7) # five percent rating for 70% weightage 
worst_rating = (0.1*0.7) # 10 percent rating for 70% weightage


#getting total interest rates
min_interest_rate = best_rating + interst_per_factor_min 
max_interest_rate = worst_rating + interst_per_factor_max


def ret(order_value,loan_length):
	if (((order_value < 100000) or (order_value > 5000000)) or ((loan_length < 6) or (loan_length > 36))): #hardKO 
		result == "REJECT"
	else
		result == "ACCEPT"
		print("You have been accepted")
		print("Minimum Interest Rate:" min_interest_rate)
		print("Maximum Interest Rate:" max_interest_rate)
		return min_interest_rate, max_interest_rate
	return