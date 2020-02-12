import React, {useState} from 'react';
import {Button, Container, Form, FormGroup, Input, Modal, ModalFooter} from "reactstrap";
import ModalHeader from "reactstrap/es/ModalHeader";
import ModalBody from "reactstrap/es/ModalBody";


export const Requisites = () => {

    const [requisites, setRequisites] = useState({payBills: []});

    const [isEditable, setEditable] = useState(false);

    const [showModal, setShowModal] = useState(false);

    const [newPayBill, setNewPayBill] = useState('');

    const handleInputChange = event => setRequisites({
        ...requisites,
        [event.target.name]: event.target.value
    });

    const handleChangePayBill = (event) => setNewPayBill(event.target.value);

    const handleCheckboxChange = event => setEditable(event.target.checked);

    const changeShow = () => setShowModal(!showModal);

    const handleSaveNewPayBill = () => {
        const payBills = [...requisites.payBills];
        payBills.push(newPayBill);
        setRequisites({
            ...requisites,
            payBills: payBills
        });
        changeShow();
    };

    const deletePayBill = payBill => {
        const payBills = requisites.payBills.filter(bill => bill !== payBill);
        setRequisites({
            ...requisites,
            payBills: payBills
        });
    };

    const createPayBills = () => {
        const payBills = requisites.payBills.map(payBill =>
            <tr key={payBill}>
                <td>{payBill}</td>
                <td><Button className='btn-danger' onClick={() => deletePayBill(payBill)}/></td>
            </tr>);

        return <table><tbody>{payBills}</tbody></table>;
    };

    return (
        <Container className='col-md-4'>
            <h1>Реквизиты</h1>
            <FormGroup>
                <Input id='edit' type='checkbox' name='isEditable' onChange={handleCheckboxChange}/>
                <label htmlFor='edit'>Редактирование</label>
            </FormGroup>
            <Form>
                <FormGroup>
                    <label htmlFor='russianName'>Название(рус.)</label>
                    <Input id='russianName' type='text' name='russianName'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>

                <FormGroup>
                    <label htmlFor='belarusianName'>Название(бел.)</label>
                    <Input id='belarusianName' type='text' name='belarusianName'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>

                <FormGroup>
                    <label htmlFor='shortName'>Название(сокр.)</label>
                    <Input id='shortName' type='text' name='shortName'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>

                <FormGroup>
                    <label htmlFor='legalAddress'>Адрес юридический</label>
                    <Input id='legalAddress' type='text' name='legalAddress'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>

                <FormGroup>
                    <label htmlFor='postAddress'>Адрес почтовый</label>
                    <Input id='postAddress' type='text' name='postAddress'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>

                <FormGroup>
                    <label htmlFor='email'>Email</label>
                    <Input id='email' type='email' name='email'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>

                <FormGroup>
                    <label htmlFor=''>Расчетные счета</label>
                    <Button className='btn-success' disabled={!isEditable} onClick={changeShow}>Добавить</Button>
                </FormGroup>

                {createPayBills()}

                <FormGroup>
                    <label htmlFor='nceo'>ОКПО</label>
                    <Input id='nceo' type='text' name='nceo'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>

                <FormGroup>
                    <label htmlFor='payerAccNumber'>УНП</label>
                    <Input id='payerAccNumber' type='text' name='payerAccNumber'
                           onChange={handleInputChange} disabled={!isEditable}/>
                </FormGroup>
            </Form>

            {/*    Modal to add new bills*/}
            <Modal isOpen={showModal} toggle={changeShow}>
                <ModalHeader toggle={changeShow}>Добавить расчетный счет</ModalHeader>
                <ModalBody>
                    <Input onChange={handleChangePayBill} type='text'/>
                </ModalBody>
                <ModalFooter>
                    <Button className='btn-success' onClick={handleSaveNewPayBill}>Добавить</Button>
                </ModalFooter>
            </Modal>
        </Container>
    );
};