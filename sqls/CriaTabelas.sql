insert into CLIENTES (cpf,nome,endereco,telefone,sexo,dataDeNascimento) values ('06722' , 'megale' , 'viamao869' , '33715002' , 'm' , '1984-12-04');
insert into VEICULOS (placa,nome,modelo,marca,anoDeFabricacao,anoDeVenda) values ('hmp-0774' , 'Civic' , 'ELX' , 'Honda' , '1998' , '2001');
insert into VEICULOS (placa,nome,modelo,marca,anoDeFabricacao,anoDeVenda) values ('GZN-2978' , 'Grand Vitara' , 'Auto' , 'Suzuki' , '2001' , '2014');

select placa,nome,modelo,marca,anoDeFabricacao,anoDeVenda from VEICULOS order by placa;
select nome, cpf, endereco, telefone, sexo, dataDeNascimento from CLIENTES order by nome;


