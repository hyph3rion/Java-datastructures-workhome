package model;


	public enum ProcedureType {
	    LIMPIEZA, CALZAS, EXTRACCION, DIAGNOSTICO;

	    public double getUnitFee(ClientType clientType) {
	        return switch (clientType) {
	            case PARTICULAR -> switch (this) {
	                case LIMPIEZA -> 60000;
	                case CALZAS -> 80000;
	                case EXTRACCION -> 100000;
	                case DIAGNOSTICO -> 50000;
	            };
	            case EPS -> switch (this) {
	                case LIMPIEZA, DIAGNOSTICO -> 0;
	                case CALZAS, EXTRACCION -> 40000;
	            };
	            case PREPAGADA -> switch (this) {
	                case LIMPIEZA, DIAGNOSTICO -> 0;
	                case CALZAS, EXTRACCION -> 10000;
	            };
	        };
	    }
	}

