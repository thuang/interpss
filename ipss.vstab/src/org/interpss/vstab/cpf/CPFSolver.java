package org.interpss.vstab.cpf;

import org.apache.commons.math.linear.RealMatrix;

public interface CPFSolver {
	

	public boolean solveCPF();
	
	public boolean isCPFConverged();
	
	

}