---pp y pg--
if v_reslocal - v_resvisit > 0 then
	SET v_pg = v_pg+1:
else
	SET v_pp=v_pp+1;
END IF;

--pf--
SELECT SUM(reslocal)
	INTO v_reslocal
	FROM partido
	WHERE local="mad";
SELECT SUM(resvisit)
	INTO v_resvisit
	FROM partido
	WHERE visitante="mad";
	SET v_pf = v_reslocal + v_resvisitante;

--PC--
SELECT SUM(resvisit)
	INTO v_reslocal
	FROM partido
	WHERE local="mad";
SELECT SUM(reslocal)
	INTO v_resvisit
	FROM partido
	WHERE visitante="mad";
	SET v_pc = v_reslocal + v_resvisitante;

---dif---
SET v_dif=v_pf +v_pc;
	