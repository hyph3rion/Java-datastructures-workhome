package model;

public record PricingBreakdown(
	    double baseAppointmentFee,
	    double unitProcedureFee,
	    double procedureSubtotal,
	    double totalToPay
	) {}