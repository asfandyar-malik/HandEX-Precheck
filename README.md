## PRECHECK (VORAB-CHECK)


<img width="287" alt="HandEX_logo1 png_2021-12-25_15-12-59-removebg-preview" src="https://user-images.githubusercontent.com/4105873/147386876-b90519b8-d6cc-45e4-83ea-91e2bcf72a4e.png">


```
psql -h "ec2-54-228-252-67.eu-west-1.compute.amazonaws.com" -U "user" -d "db2bf10ik0id0h" -c "\copy country_risk_premiums(country, rating_based_default_spread, total_equity_risk_premium, country_risk_premium) FROM '/Users/asfandyar/Desktop/country_risk_premiums.csv' WITH (FORMAT csv, header true, delimiter ',');"
```

```
psql -h "ec2-54-228-252-67.eu-west-1.compute.amazonaws.com" -U "user" -d "db2bf10ik0id0h" -c "\copy industry_betas(industry_name, eh_equivalent_industry_name_english, eh_equivalent_industry_name_germany, eh_nace, true_nace, levered_beta, average_levered_beta) FROM '/Users/asfandyar/Desktop/industry_betas.csv' WITH (FORMAT csv, header true, delimiter ',');"```
