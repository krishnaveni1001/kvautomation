package us.cargosphere.automation.domain;

public class UIContractDataLoad {

    public static class Contract {

        public static class CommodityGroup {
            private String commodityGroupName;
            private String commodityGroupType;
            private String [] commodities;
            private boolean fak;
            private String hazardousIndicator;

            public String getCommodityGroupName() {
                return commodityGroupName;
            }

            public void setCommodityGroupName(String commodityGroupName) {
                this.commodityGroupName = commodityGroupName;
            }

            public String getCommodityGroupType() {
                return commodityGroupType;
            }

            public void setCommodityGroupType(String commodityGroupType) {
                this.commodityGroupType = commodityGroupType;
            }

            public String[] getCommodities() {
                return commodities;
            }

            public void setCommodities(String[] commodities) {
                this.commodities = commodities;
            }

            public boolean isFak() {
                return fak;
            }

            public void setFak(boolean fak) {
                this.fak = fak;
            }

            public String getHazardousIndicator() {
                return hazardousIndicator;
            }

            public void setHazardousIndicator(String hazardousIndicator) {
                this.hazardousIndicator = hazardousIndicator;
            }
        }

        public static class Origin {
            private String origin;
            private String routing;

            public String getOrigin () {
                return origin;
            }

            public void setOrigin (String origin) {
                this.origin = origin;
            }

            public String getRouting () {
                return routing;
            }

            public void setRouting (String routing) {
                this.routing = routing;
            }
        }

        public static class Destination {
            private String destination;
            private String routing;

            public String getDestination () {
                return destination;
            }

            public void setDestination (String destination) {
                this.destination = destination;
            }

            public String getRouting () {
                return routing;
            }

            public void setRouting (String routing) {
                this.routing = routing;
            }
        }

        public static class NamedAccountGroup {
            private String namedAccountGroupName;
            private String[] namedAccounts;
            // TODO use namedByIndicator to apply named accounts by company, email, or contact
            private String namedByIndicator;

            public String getNamedAccountGroupName() {
                return namedAccountGroupName;
            }

            public void setNamedAccountGroupName(String namedAccountGroupName) {
                this.namedAccountGroupName = namedAccountGroupName;
            }

            public String[] getNamedAccounts () {
                return namedAccounts;
            }

            public void setNamedAccounts (String[] namedAccounts) {
                this.namedAccounts = namedAccounts;
            }

            public String getNamedByIndicator() {
                return namedByIndicator;
            }

            public void setNamedByIndicator(String namedByIndicator) {
                this.namedByIndicator = namedByIndicator;
            }
        }

        public static class SurchargeData {

            public static class LevelOneSurcharge {
                private String term;
                private String applicability;
                private String category;
                private String priceBy;
                private String amount;
                private String currency;
                private String excludeFromTotal;
                private String containerType;
                private String origin;
                private String destination;

                public String getTerm() {
                    return term;
                }

                public void setTerm(String term) {
                    this.term = term;
                }

                public String getApplicability() {
                    return applicability;
                }

                public void setApplicability(String applicability) {
                    this.applicability = applicability;
                }

                public String getCategory() { return category; }

                public void setCategory(String category) { this.category = category; }

                public String getPriceBy() {
                    return priceBy;
                }

                public void setPriceBy(String priceBy) {
                    this.priceBy = priceBy;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getCurrency() {
                    return currency;
                }

                public void setCurrency(String currency) {
                    this.currency = currency;
                }

                public String getExcludeFromTotal() {
                    return excludeFromTotal;
                }

                public void setExcludeFromTotal(String excludeFromTotal) {
                    this.excludeFromTotal = excludeFromTotal;
                }

                public String getContainerType() {
                    return containerType;
                }

                public void setContainerType(String containerType) {
                    this.containerType = containerType;
                }

                public String getOrigin() {
                    return origin;
                }

                public void setOrigin(String origin) {
                    this.origin = origin;
                }

                public String getDestination() {
                    return destination;
                }

                public void setDestination(String destination) {
                    this.destination = destination;
                }
            }

            private LevelOneSurcharge[] levelOneSurcharges;

            public LevelOneSurcharge[] getLevelOneSurcharges() {
                return levelOneSurcharges;
            }

            public void setLevelOneSurcharges (LevelOneSurcharge[] levelOneSurcharges) {
                this.levelOneSurcharges = levelOneSurcharges;
            }

        }

        private String contractName;
        private boolean lcl;
        private String carrier;
        private String owner;
        private String tradeLane;
        private CommodityGroup commodityGroup;
        private String [] containerTypes;
        private String serviceType;
        private String serviceString;
        private String vessel;
        private String rateType;
        private NamedAccountGroup namedAccountGroup;
        private String rateTypeTwo;
        private String addOn;
        private Origin [] origins;
        private Destination [] destinations;
        private String [] rates;
        private SurchargeData surchargeData;


        public String getContractName() {
            return contractName;
        }

        public void setContractName(String contractName) {
            this.contractName = contractName;
        }

        public boolean isLcl() {return lcl;}

        public void setLcl(boolean lcl) {
            this.lcl = lcl;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getTradeLane() {
            return tradeLane;
        }

        public void setTradeLane(String tradeLane) {
            this.tradeLane = tradeLane;
        }

        public CommodityGroup getCommodityGroup() {
            return commodityGroup;
        }

        public void setCommodityGroup(CommodityGroup commodityGroup) {
            this.commodityGroup = commodityGroup;
        }

        public String[] getContainerTypes() {
            return containerTypes;
        }

        public void setContainerTypes(String[] containerTypes) {
            this.containerTypes = containerTypes;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getServiceString() {
            return serviceString;
        }

        public void setServiceString(String serviceString) {
            this.serviceString = serviceString;
        }

        public String getVessel() {
            return vessel;
        }

        public void setVessel(String vessel) {
            this.vessel = vessel;
        }

        public String getRateType() {
            return rateType;
        }

        public void setRateType(String rateType) {
            this.rateType = rateType;
        }

        // TODO add options for named account to be added by email or contact
        public NamedAccountGroup getNamedAccountGroup() { return namedAccountGroup; }

        public void setNamedAccount(NamedAccountGroup namedAccountGroup) {
            this.namedAccountGroup = namedAccountGroup;
        }

        public String getRateTypeTwo() {
            return rateTypeTwo;
        }

        public void setRateTypeTwo(String rateTypeTwo) {
            this.rateTypeTwo = rateTypeTwo;
        }

        public String getAddOn() {
            return addOn;
        }

        public void setAddOn(String addOn) {
            this.addOn = addOn;
        }

        public Origin[] getOrigins() {
            return origins;
        }

        public void setOrigins(Origin[] origins) {
            this.origins = origins;
        }

        public Destination[] getDestinations() {
            return destinations;
        }

        public void setDestinations(Destination[] destinations) {
            this.destinations = destinations;
        }

        public String[] getRates() {
            return rates;
        }

        public void setRates(String[] rates) {
            this.rates = rates;
        }

        public SurchargeData getSurchargeData() {
            return surchargeData;
        }

        public void setSurchargeData(SurchargeData surchargeDate) {
            this.surchargeData = surchargeDate;
        }
    }

    private Contract[] contracts;
    private String environment;
    private String environmentPass;
    private String user;
    private String userPass;

    public void setContracts (Contract[] contracts) {
        this.contracts = contracts;
    }

    public Contract[] getContracts () {
        return contracts;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironmentPass() {
        return environmentPass;
    }

    public void setEnvironmentPass(String environmentPass) {
        this.environmentPass = environmentPass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}

