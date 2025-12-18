import MenuModifyForm from "@/components/form/MenuModifyForm";

// 페이지 컴포넌트는 params를 받을 수 있습니다.
export default function MenuModifyPage({ params }) {
    const { id } = params;

    return (
        <>
            {/* 받은 id를 MenuModifyForm 컴포넌트에 props로 전달! */}
            <MenuModifyForm id={id} />
        </>
    )
}